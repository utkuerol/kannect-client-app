package com.example.asus.example.mvvm.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.asus.example.mvvm.ViewModel.ItemUserViewModel;

/**
 * activity for adding a new Post
 */
public class NewUserPostFragment extends Fragment {

    private ItemUserViewModel viewModel;
    //binding


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public ItemUserViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(ItemUserViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
