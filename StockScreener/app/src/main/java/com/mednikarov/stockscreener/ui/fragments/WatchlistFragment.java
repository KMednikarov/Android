package com.mednikarov.stockscreener.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mednikarov.stockscreener.R;
import com.mednikarov.stockscreener.data.model.WatchlistStock;
import com.mednikarov.stockscreener.databinding.FragmentWatchlistBinding;
import com.mednikarov.stockscreener.ui.adapters.WatchlistViewHolder;
import com.mednikarov.stockscreener.viewmodels.WatchlistViewModel;
import com.mednikarov.stockscreener.ui.adapters.WatchlistItemChanged;
import com.mednikarov.stockscreener.ui.adapters.WatchlistAdapter;

import java.util.Collections;
import java.util.List;


/**
 * A simple {@link Fragment} subclass used for the watchlist menu.
 * Use the {@link WatchlistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WatchlistFragment extends Fragment implements WatchlistItemChanged {
    private FragmentWatchlistBinding mBinding;
    private WatchlistAdapter mAdapter;
    private WatchlistViewModel mViewModel;


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
    public static WatchlistFragment newInstance() {
        return new WatchlistFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_watchlist, container, false);
        mViewModel = ViewModelProviders.of(this).get(WatchlistViewModel.class);
        WatchlistViewHolder.addObserver(this);
        setupRecyclerView();
        observeData();
        getViewModel().refreshData();

        return mBinding.getRoot();
    }

    /***
     * Observe WatchlistLiveData for changes
     */
    private void observeData(){
        getViewModel().getWatchlistLiveData().observe(getViewLifecycleOwner(), new Observer<List<WatchlistStock>>() {
            @Override
            public void onChanged(List<WatchlistStock> stocks) {
                mAdapter.clearWatchlist();
                for(WatchlistStock stock: stocks){
                    mAdapter.addToWatchlist(stock);
                }
                mBinding.watchlistRecyclerView.setAdapter(mAdapter);
            }
        });
    }

    private WatchlistViewModel getViewModel(){
        return mViewModel;
    }

    /***
     * Add layout manager, attach the adapter to the recycler view and add touch helper.
     */
    private void setupRecyclerView() {
        mAdapter = WatchlistAdapter.newInstance();
        mBinding.watchlistRecyclerView.setLayoutManager(new LinearLayoutManager(mBinding.getRoot().getContext()));
        mBinding.watchlistRecyclerView.setAdapter(mAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(createHelperCallback());
        itemTouchHelper.attachToRecyclerView(mBinding.watchlistRecyclerView);
    }

    @Override
    public void onAddedToWatchlist(WatchlistStock stock) {
        //getViewModel().addToWatchlist(quote);
        //getViewModel().refreshData();
    }

    @Override
    public void onRemovedFromWatchlist(WatchlistStock stock) {
        getViewModel().removeFromWatchlist(stock);
        mAdapter.clearWatchlist();
        getViewModel().refreshData();
    }

    /***
     * Create a callback helper to handle CardView swipes (UP, DOWN, LEFT, RIGHT).
     * If the item is moved up/down - swap item positions.
     * If the item is swiped left/right - remove stock from watchlist.
     * @return
     */
    private ItemTouchHelper.Callback createHelperCallback() {
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                if(viewHolder.getItemViewType() != target.getItemViewType()){
                    return false;
                }

                int dragFrom = viewHolder.getBindingAdapterPosition();
                int dragTo = target.getBindingAdapterPosition();

                if(dragFrom == -1 || dragTo == -1 || dragFrom == dragTo){
                    return false;
                }

                swapWatchlistItems(dragFrom, dragTo);

                return true;
            }

            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int position = viewHolder.getBindingAdapterPosition();
                removeWatchlistItem(position);
            }
        };

        return simpleItemTouchCallback;
    }

    /***
     * Swap two watchlist items positions.
     * @param position
     * @param newPosition
     */
    private void swapWatchlistItems(int position, int newPosition) {
        Collections.swap(mAdapter.getStockList(), position, newPosition);
        mAdapter.notifyItemMoved(position, newPosition);
    }

    /***
     * Remove watchlist item from the adapter's list
     * @param position
     */
    private void removeWatchlistItem(int position){
        WatchlistStock stock = mAdapter.getItemAt(position);
        mAdapter.removeItemAt(position);
        mAdapter.notifyItemRemoved(position);
        getViewModel().removeFromWatchlist(stock);
    }
}
