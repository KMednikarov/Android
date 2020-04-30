package com.learn.hotornot.overall;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learn.hotornot.R;
import com.learn.hotornot.WeatherObserver;
import com.learn.hotornot.data.DataRepository;
import com.learn.hotornot.data.models.CurrentWeather;
import com.learn.hotornot.databinding.FragmentOverallBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OverallFragmentListener} interface
 * to handle interaction events.
 * Use the {@link OverallFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OverallFragment extends Fragment implements WeatherObserver {
    public static final String TITLE = "Today";
    private static DataRepository mDataRepository;
    private FragmentOverallBinding binding;
    private OverallAdapter adapter;
    private OverallFragmentListener mListener;

    public OverallFragment() {
    }

    public static OverallFragment newInstance(DataRepository dataRepository) {
        mDataRepository = dataRepository;
        OverallFragment fragment = new OverallFragment();
        //Bundle args = new Bundle();
        //fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // mWeatherModel = (WeatherModel) getArguments().getSerializable(ARG_WEATHER_MODEL);
        }
    }

    private void setupRecyclerView() {
        adapter = new OverallAdapter();
        binding.overallRecyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
        binding.overallRecyclerView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_overall, container, false);
        mDataRepository.attach(this);
        setupRecyclerView();

        return binding.getRoot();
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onOverallFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OverallFragmentListener) {
            mListener = (OverallFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void update() {
        List<CurrentWeather> weatherList = new ArrayList<>();
        weatherList.add(mDataRepository.getWeatherModel().getCurrentWeather());
        adapter.addWeatherModel(weatherList);
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OverallFragmentListener {
        // TODO: Update argument type and name
        void onOverallFragmentInteraction(Uri uri);
    }
}
