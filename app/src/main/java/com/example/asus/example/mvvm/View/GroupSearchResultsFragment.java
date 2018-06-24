package com.example.asus.example.mvvm.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.asus.example.mvvm.ViewModel.GroupViewModel;

public class GroupSearchResultsFragment extends Fragment {

    GroupViewModel viewModel;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //set binding
        //sets adapter
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        //find view model
        //viewmodel.observe(this) --- sync with adapter
    }
}
