package com.mednikarov.stockscreener.views.search;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mednikarov.stockscreener.R;
import com.mednikarov.stockscreener.data.model.Quote;
import com.mednikarov.stockscreener.databinding.FragmentSearchBinding;
import com.mednikarov.stockscreener.viewmodels.SearchViewModel;
import com.mednikarov.stockscreener.views.WatchlistItemChanged;
import com.mednikarov.stockscreener.views.search.recyclerview.SearchAdapter;
import com.mednikarov.stockscreener.views.search.recyclerview.SearchViewHolder;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
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

    private void observeSearchLiveData() {
        getViewModel().getSearchLiveData().observe(getViewLifecycleOwner(), stockBatch -> {
            mAdapter.clearList();
            mAdapter.addToList(stockBatch);
            binding.searchRecyclerView.setAdapter(mAdapter);
        });
    }

    private void setupRecyclerView() {
        mAdapter = SearchAdapter.newInstance();
        binding.searchRecyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
        binding.searchRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onAddedToWatchlist(Quote quote) {

        getViewModel().addToWatchlist(quote);
        getViewModel().updateStockData();
    }

    @Override
    public void onRemovedFromWatchlist(Quote quote) {
        getViewModel().removeFromWatchlist(quote);
        getViewModel().updateStockData();
    }

    private SearchViewModel getViewModel(){
        return mViewModel;
    }

    private final TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            getViewModel().searchStock(v.getText().toString().toUpperCase());
            return false;
        }
    };
}
