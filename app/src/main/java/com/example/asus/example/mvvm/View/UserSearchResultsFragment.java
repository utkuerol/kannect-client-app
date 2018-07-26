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

import com.example.asus.example.databinding.FragmentUserSearchResultBinding;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerUser;
import com.example.asus.example.mvvm.View.Adapter.UserAdapter;
import com.example.asus.example.mvvm.ViewModel.UserViewModel;

import java.util.List;

/**
 * Fragment for the view, to show all users which match the search query.
 */
public class UserSearchResultsFragment extends Fragment {

    private String query;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        //set viewmodel
        final UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.init(this.getContext().getApplicationContext());
        userViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    userViewModel.setUsersToSearchResults(query);
                }
            }
        });

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

        //set databinding, define the xml of the fragment
        final FragmentUserSearchResultBinding fragmentUserSearchResultBinding = FragmentUserSearchResultBinding.inflate(inflater, parent, false);
        fragmentUserSearchResultBinding.userSearchResultUserRV.setAdapter(userAdapter);

        userViewModel.getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                if (users != null) {
                    userAdapter.setUserList(userViewModel.getUsers().getValue());
                    fragmentUserSearchResultBinding.userSearchResultUserRV.setAdapter(userAdapter);
                }
            }
        });

        fragmentUserSearchResultBinding.userSearchResultUserRV.setLayoutManager(new LinearLayoutManager(this.getContext()));


        return fragmentUserSearchResultBinding.getRoot();
    }

    public void setQuery(String query) {

        this.query = query;
    }

}
