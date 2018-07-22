package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentPersonalFeedBinding;
import com.example.asus.example.mvvm.View.Adapter.PostAdapter;
import com.example.asus.example.mvvm.ViewModel.PostViewModel;

/**
 * Personal Feed Activity to show all Posts for this signed user of his groups , posts , events
 */
public class PersonalFeedFragment extends Fragment {

    private PostViewModel postViewModel;

    FragmentPersonalFeedBinding fragmentPersonalFeedBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_personal_feed, parent, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        //set viewmodel
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.setPostsToPersonalFeed();

        //set adapter
        PostAdapter postAdapter = new PostAdapter();
        postAdapter.setPostList(postViewModel.getPosts().getValue());
        fragmentPersonalFeedBinding.personalFeedRV.setAdapter(postAdapter);
        fragmentPersonalFeedBinding.personalFeedRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //TODO: observe livedata somehow

    }


}
