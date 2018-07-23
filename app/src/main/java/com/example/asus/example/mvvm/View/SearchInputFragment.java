package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.databinding.FragmentPersonalFeedBinding;
import com.example.asus.example.mvvm.View.Adapter.PostAdapter;
import com.example.asus.example.mvvm.ViewModel.PostViewModel;

public class SearchInputFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        //set viewmodel
        PostViewModel postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.setPostsToPersonalFeed();

        //set adapter
        PostAdapter postAdapter = new PostAdapter();
        postAdapter.setPostList(postViewModel.getPosts().getValue());


        //set databinding
        FragmentPersonalFeedBinding fragmentPersonalFeedBinding = FragmentPersonalFeedBinding.inflate(inflater, parent, false);
        fragmentPersonalFeedBinding.personalFeedRV.setAdapter(postAdapter);
        fragmentPersonalFeedBinding.personalFeedRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //TODO: observe livedata somehow

        return fragmentPersonalFeedBinding.getRoot();

    }

}
