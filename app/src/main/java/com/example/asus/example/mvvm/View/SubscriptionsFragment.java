package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.databinding.FragmentSubscriptionsBinding;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerUser;
import com.example.asus.example.mvvm.View.Adapter.UserAdapter;
import com.example.asus.example.mvvm.ViewModel.UserViewModel;

public class SubscriptionsFragment extends Fragment {


    private User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        //set viewmodel
        final UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.init(this.getContext().getApplicationContext());

        //set adapter
        final UserAdapter userAdapter = new UserAdapter();
        OnItemClickListenerUser listener = new OnItemClickListenerUser() {
            @Override
            public void onItemClick(User user) {

                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchUserProfileFragment(user);

            }
        };
        userAdapter.setListener(listener);

        //set binding
        final FragmentSubscriptionsBinding fragmentSubscriptionsBinding = FragmentSubscriptionsBinding.inflate(inflater, parent, false);
        fragmentSubscriptionsBinding.subscriptionsUserRV.setAdapter(userAdapter);

        userViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    userViewModel.setUsersToSubscriptions();
                    userAdapter.setUserList(userViewModel.getUsers().getValue());
                    fragmentSubscriptionsBinding.subscriptionsUserRV.setAdapter(userAdapter);

                }
            }
        });
        fragmentSubscriptionsBinding.subscriptionsUserRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return fragmentSubscriptionsBinding.getRoot();
    }


    public void setUser(User user) {
        this.user = user;
    }

}
