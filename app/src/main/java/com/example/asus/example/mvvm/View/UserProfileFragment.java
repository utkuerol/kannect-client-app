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

import com.example.asus.example.databinding.FragmentUserProfileBinding;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerPost;
import com.example.asus.example.mvvm.View.Adapter.PostAdapter;
import com.example.asus.example.mvvm.ViewModel.ItemUserViewModel;

import java.util.List;

/**
 * User Profile Activity to show all Posts for this User
 */
public class UserProfileFragment extends Fragment {

    private User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        //set viewmodel
        final ItemUserViewModel itemUserViewModel = ViewModelProviders.of(this).get(ItemUserViewModel.class);
        itemUserViewModel.init(user, this.getContext().getApplicationContext());

        //set adapter
        final PostAdapter postAdapter = new PostAdapter();

        OnItemClickListenerPost listener = new OnItemClickListenerPost() {
            @Override
            public void onItemClick(Post post) {

                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchShowPostFragment(post);

            }
        };
        postAdapter.setListener(listener);


        //set binding
        final FragmentUserProfileBinding fragmentUserProfileBinding = FragmentUserProfileBinding.inflate(inflater, parent, false);
        fragmentUserProfileBinding.userProfilePostRV.setAdapter(postAdapter);


        final Observer<List<Post>> postsObserver = new Observer<List<Post>>() {
            @Override
            public void onChanged(@Nullable List<Post> posts) {
                if (posts != null) {
                    postAdapter.setPostList(itemUserViewModel.getUserProfile().getValue());
                    fragmentUserProfileBinding.userProfilePostRV.setAdapter(postAdapter);
                }
            }
        };


        itemUserViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    fragmentUserProfileBinding.setItemUserViewModel(itemUserViewModel);
                    itemUserViewModel.getUserProfile().observe(UserProfileFragment.this, postsObserver);
                }
            }
        });

        fragmentUserProfileBinding.userProfilePostRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return fragmentUserProfileBinding.getRoot();

    }


    public void setUser(User user) {
        this.user = user;
    }
}
