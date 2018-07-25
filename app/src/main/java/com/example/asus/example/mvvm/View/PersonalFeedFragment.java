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

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentPersonalFeedBinding;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.PostAdapter;
import com.example.asus.example.mvvm.ViewModel.PostViewModel;

import java.util.List;

/**
 * Personal Feed Activity to show all Posts for this signed user of his groups , posts , events
 */
public class PersonalFeedFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        FragmentPersonalFeedBinding fragmentPersonalFeedBinding = FragmentPersonalFeedBinding.inflate(inflater, parent, false);
        //set viewmodel
        final PostViewModel postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.init(this.getContext().getApplicationContext());

        postViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    postViewModel.setPostsToPersonalFeed();
                }
            }
        });

        //set adapter
        final PostAdapter postAdapter = new PostAdapter();
        postViewModel.getPosts().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(@Nullable List<Post> posts) {
                if (posts != null) {
                    postAdapter.setPostList(posts);

                }
            }
        });

        //set databinding
        fragmentPersonalFeedBinding.personalFeedPostRV.setAdapter(postAdapter);
        fragmentPersonalFeedBinding.personalFeedPostRV.setLayoutManager(new LinearLayoutManager(this.getContext()));



        return fragmentPersonalFeedBinding.getRoot();

    }

    public void launchFragment() {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
        navigation_drawer_activity.launchPersonalFeedFragment();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.newEventInCategoryButton:
                launchFragment();
                break;
        }
    }
}
