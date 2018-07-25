package com.example.asus.example.mvvm.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.ViewModel.ItemGroupViewModel;

public class NewGroupPostFragment extends Fragment {

    private ItemGroupViewModel viewModel;
    //binding

    private Group group;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public ItemGroupViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(ItemGroupViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void launchFragment() {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
        navigation_drawer_activity.launchNewGroupPostFragment();
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
