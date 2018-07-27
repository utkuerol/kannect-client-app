package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentPersonalFeedBinding;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerPost;
import com.example.asus.example.mvvm.View.Adapter.PostAdapter;
import com.example.asus.example.mvvm.ViewModel.PostViewModel;

import java.util.List;

/**
 * Personal Feed Activity to show all Posts for this signed user of his groups , posts , events
 */
public class PersonalFeedFragment extends Fragment implements View.OnClickListener {

    private FragmentPersonalFeedBinding fragmentPersonalFeedBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        fragmentPersonalFeedBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_personal_feed, parent, false);

        //set viewmodel
        final PostViewModel postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);


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

        //set databinding
        ImageView personalFeedCreatePostIV = (ImageView) fragmentPersonalFeedBinding.personalFeedCreatePostIV;
        personalFeedCreatePostIV.setOnClickListener(this);

        fragmentPersonalFeedBinding.personalFeedPostRV.setAdapter(postAdapter);

        postViewModel.init(this.getContext().getApplicationContext());

        postViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    postViewModel.setPostsToPersonalFeed();
                    fragmentPersonalFeedBinding.personalFeedPostRV.setAdapter(postAdapter);

                }
            }
        });

        postViewModel.getPosts().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(@Nullable List<Post> posts) {
                if (posts != null) {
                    postAdapter.setPostList(posts);
                }
            }
        });

        fragmentPersonalFeedBinding.personalFeedPostRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return fragmentPersonalFeedBinding.getRoot();
    }

    @Override
    public void onClick(View v) {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
        switch (v.getId()) {
            case R.id.personalFeedCreatePostIV:
                navigation_drawer_activity.launchNewUserPostFragment();
                break;
        }
    }


}
