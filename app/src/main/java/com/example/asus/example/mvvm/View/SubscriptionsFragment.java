package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentSubscriptionsBinding;
import com.example.asus.example.mvvm.Interfaces.OnItemClickListenerUser;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.UserAdapter;
import com.example.asus.example.mvvm.ViewModel.UserViewModel;

public class SubscriptionsFragment extends Fragment {


    private User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        //set viewmodel
        UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.init();
        userViewModel.setUsersToSubscriptions();

        //set adapter
        UserAdapter userAdapter = new UserAdapter();
        userAdapter.setUserList(userViewModel.getUsers().getValue());

        OnItemClickListenerUser listener = new OnItemClickListenerUser() {
            @Override
            public void onItemClick(User user) {

                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchUserProfileFragment(user);

            }
        };
        userAdapter.setListener(listener);
        //set binding
        FragmentSubscriptionsBinding fragmentSubscriptionsBinding = FragmentSubscriptionsBinding.inflate(inflater, parent, false);
        fragmentSubscriptionsBinding.subscriptionsUserRV.setAdapter(userAdapter);
        fragmentSubscriptionsBinding.subscriptionsUserRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //TODO: observe livedata somehow

        return inflater.inflate(R.layout.fragment_user_profile, parent, false);
    }


    public void setUser(User user) {
        this.user = user;
    }
}
