package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.databinding.FragmentShowPostBinding;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.ViewModel.ItemPostViewModel;

/**
 * Activity class for the view regarding showing a Post and its comments.
 * Uses the ItemPostViewModel as its ViewModel.
 */
public class ShowPostFragment extends Fragment {


    private Post post;


    public void setPost(Post post) {
        this.post = post;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        //get extra arguments from the initiating activity


        //set viewmodel
        ItemPostViewModel itemPostViewModel = ViewModelProviders.of(this).get(ItemPostViewModel.class);
        itemPostViewModel.init(post);

        //set adapter for comments recycler view (if we implement this feature eventually

        //set databinding
        FragmentShowPostBinding fragmentShowPostBinding = FragmentShowPostBinding.inflate(inflater, parent, false);
        fragmentShowPostBinding.setItemPostViewModel(itemPostViewModel);

        //TODO: observe livedata somehow

        return fragmentShowPostBinding.getRoot();

    }
}
