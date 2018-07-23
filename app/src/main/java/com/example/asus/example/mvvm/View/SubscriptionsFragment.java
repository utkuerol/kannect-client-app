package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.databinding.FragmentSubscriptionsBinding;
import com.example.asus.example.mvvm.View.Adapter.UserAdapter;
import com.example.asus.example.mvvm.ViewModel.UserViewModel;

public class SubscriptionsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        //set viewmodel
        UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.init();
        userViewModel.setUsersToSubscriptions();

        //set adapter
        UserAdapter userAdapter = new UserAdapter();
        userAdapter.setUserList(userViewModel.getUsers().getValue());

        //set binding
        FragmentSubscriptionsBinding fragmentSubscriptionsBinding = FragmentSubscriptionsBinding.inflate(inflater, parent, false);
        fragmentSubscriptionsBinding.subscriptionsUserRV.setAdapter(userAdapter);
        fragmentSubscriptionsBinding.subscriptionsUserRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //TODO: observe livedata somehow

        return fragmentSubscriptionsBinding.getRoot();
    }

    public void launchFragment() {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
        navigation_drawer_activity.launchSubscriptionsFragment();
    }
}
