package com.example.asus.example.mvvm.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.asus.example.mvvm.ViewModel.GroupViewModel;

public class GroupSearchResultsFragment extends Fragment {

    GroupViewModel viewModel;
    /**
     * Called immediately after onCreateView(LayoutInflater, ViewGroup, Bundle) has returned,
     * but before any saved state has been restored in to the view.
     * Initializes the Data binding and sets the adapter for the recylcer view.
     * @param view The View returned by onCreateView(LayoutInflater, ViewGroup, Bundle).
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //set binding
        //sets adapter
    }


    /**
     * Called when the Fragments activity has been create and this fragments view hierarchy instantiated.
     * finds the correct View Model and makes it observe this Fragment, to sync with adapter.
     * @param savedInstanceState If the fragment is being re-created from a previous saved state, this is the state.
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        //find view model
        //viewmodel.observe(this) --- sync with adapter
    }
}
