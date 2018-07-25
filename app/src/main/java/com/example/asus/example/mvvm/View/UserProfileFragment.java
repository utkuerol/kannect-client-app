package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.databinding.FragmentUserProfileBinding;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.PostAdapter;
import com.example.asus.example.mvvm.ViewModel.ItemUserViewModel;

/**
 * User Profile Activity to show all Posts for this User
 */
public class UserProfileFragment extends Fragment {


    private User user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        User user = (User) getArguments().getSerializable("user");

        //set viewmodel
        ItemUserViewModel itemUserViewModel = ViewModelProviders.of(this).get(ItemUserViewModel.class);
        itemUserViewModel.init(user);

        //set adapter
        PostAdapter postAdapter = new PostAdapter();
        postAdapter.setPostList(itemUserViewModel.getUserProfile());

        //set binding
        FragmentUserProfileBinding fragmentUserProfileBinding = FragmentUserProfileBinding.inflate(inflater, parent, false);
        fragmentUserProfileBinding.userProfilePostRV.setAdapter(postAdapter);
        fragmentUserProfileBinding.userProfilePostRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
        fragmentUserProfileBinding.setItemUserViewModel(itemUserViewModel);
        //TODO: observe livedata somehow

        return fragmentUserProfileBinding.getRoot();
    }


    public void setUser(User user) {
        this.user = user;
    }
}
