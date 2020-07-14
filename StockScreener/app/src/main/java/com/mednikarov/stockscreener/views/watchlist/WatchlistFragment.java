package com.mednikarov.stockscreener.views.watchlist;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mednikarov.stockscreener.R;
import com.mednikarov.stockscreener.data.model.Stock;
import com.mednikarov.stockscreener.databinding.FragmentWatchlistBinding;
import com.mednikarov.stockscreener.viewmodels.WatchlistViewModel;
import com.mednikarov.stockscreener.views.watchlist.recyclerview.WatchlistAdapter;
import com.mednikarov.stockscreener.views.watchlist.recyclerview.WatchlistViewHolder;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WatchlistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WatchlistFragment extends Fragment {
    public static final String TAG = WatchlistFragment.class.getSimpleName();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FragmentWatchlistBinding binding;
    private WatchlistAdapter adapter;
    private WatchlistViewModel mViewModel;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WatchlistFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment WatchlistFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WatchlistFragment newInstance(/*String param1, String param2*/) {

        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);*/
        return new WatchlistFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_watchlist, container, false);
        mViewModel = ViewModelProviders.of(this).get(WatchlistViewModel.class);
        setupRecyclerView();
        observeData();
        return binding.getRoot();
    }

    private void observeData(){
        getViewModel().updateStockData();
        getViewModel().getWatchlistLiveData().observe(this, new Observer<List<Stock>>() {
            @Override
            public void onChanged(List<Stock> stocks) {
                for(Stock stock: stocks){
                    adapter.addToWatchlist(stock);
                }
                binding.watchlistRecyclerView.setAdapter(adapter);
            }
        });
    }

    private WatchlistViewModel getViewModel(){
        return mViewModel;
    }
    private void setupRecyclerView() {
        adapter = WatchlistAdapter.newInstance();
        binding.watchlistRecyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
        binding.watchlistRecyclerView.setAdapter(adapter);


    }
}
