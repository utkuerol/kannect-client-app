package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class PersonalFeedFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        //set viewmodel
        PostViewModel postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.init(getContext());
        postViewModel.setPostsToPersonalFeed();

        //set adapter
        PostAdapter postAdapter = new PostAdapter();
        OnItemClickListenerPost listener = new OnItemClickListenerPost() {
            @Override
            public void onItemClick(Post post) {

                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchShowPostFragment(post);

            }
        };
        postAdapter.setListener(listener);
        postAdapter.setPostList(postViewModel.getPosts().getValue());


        //set databinding
        FragmentPersonalFeedBinding fragmentPersonalFeedBinding = FragmentPersonalFeedBinding.inflate(inflater, parent, false);
        fragmentPersonalFeedBinding.personalFeedPostRV.setAdapter(postAdapter);
        fragmentPersonalFeedBinding.personalFeedPostRV.setLayoutManager(new LinearLayoutManager(this.getContext()));


        return inflater.inflate(R.layout.fragment_personal_feed, parent, false);

    }


}
