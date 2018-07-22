package com.example.asus.example.mvvm.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.asus.example.mvvm.ViewModel.ItemEventViewModel;

public class NewEventPostFragment extends Fragment {

    private ItemEventViewModel viewModel;
    //binding


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public ItemEventViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(ItemEventViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
