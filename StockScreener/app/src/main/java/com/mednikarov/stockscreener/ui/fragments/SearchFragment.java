package com.mednikarov.stockscreener.ui.fragments;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mednikarov.stockscreener.R;
import com.mednikarov.stockscreener.data.model.WatchlistStock;
import com.mednikarov.stockscreener.databinding.FragmentSearchBinding;
import com.mednikarov.stockscreener.ui.adapters.SearchViewHolder;
import com.mednikarov.stockscreener.viewmodels.SearchViewModel;
import com.mednikarov.stockscreener.ui.adapters.WatchlistItemChanged;
import com.mednikarov.stockscreener.ui.adapters.SearchAdapter;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass used for the search menu.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment implements WatchlistItemChanged {
    private FragmentSearchBinding binding;
    private SearchViewModel mViewModel;
    private SearchAdapter mAdapter;


    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        mViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);

        setupRecyclerView();
        observeSearchLiveData();
        SearchViewHolder.addObserver(this);

        binding.edtSearch.setOnEditorActionListener(onEditorActionListener);

        return binding.getRoot();
    }

    /***
     * Observes the search live data.
     * Clears the adapter's list, adds a new found symbol to it and attaches the adapter to SearchRecyclerView.
     * If an error occurred (e.g. symbol is not found) shows a toast with stock not found error.
     */
    private void observeSearchLiveData() {

        getViewModel().getSearchLiveData().observe(getViewLifecycleOwner(), (WatchlistStock stock) -> {
            if(stock.getError() != null){
                showStockNotFound();
                return;
            }
            mAdapter.clearWatchlist();
            mAdapter.addToWatchlist(stock);
            binding.searchRecyclerView.setAdapter(mAdapter);
        });
    }

    /***
     * Create recycler view adapter, set layout manager (linear) and attach the adapter to SearcRecyclerView
     */
    private void setupRecyclerView() {
        mAdapter = SearchAdapter.newInstance();
        binding.searchRecyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
        binding.searchRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onAddedToWatchlist(WatchlistStock stock) {
        getViewModel().addToWatchlist(stock);
    }

    @Override
    public void onRemovedFromWatchlist(WatchlistStock stock) {
        getViewModel().removeFromWatchlist(stock);
    }

    /***
     * @return The view model for this fragment
     */
    private SearchViewModel getViewModel(){
        return mViewModel;
    }

    /***
     * Handles the entered text in the search field.
     * A search in the Yahoo API will be preformed.
     * A toast with error text will be shown if the search field is empty.
     */
    private final TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            String symbol = "";
            try{
                symbol = v.getText().toString().trim().toUpperCase();
            } catch (Exception e){
                showStockNotFound();
                return true;
            }

            getViewModel().searchStock(symbol);

            return false;
        }
    };

    /***
     * Shows a short length toast with stock not found error.
     */
    private void showStockNotFound(){
        Toast.makeText(getContext(),R.string.stock_not_found_error,Toast.LENGTH_SHORT).show();
    }

}
