package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asus.example.databinding.FragmentShowPostBinding;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemPostViewModel;

/**
 * Activity class for the view regarding showing a Post and its comments.
 * Uses the ItemPostViewModel as its ViewModel.
 */
public class ShowPostFragment extends Fragment {


    private Post post;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        //set viewmodel
        final ItemPostViewModel itemPostViewModel = ViewModelProviders.of(this).get(ItemPostViewModel.class);

        //set databinding
        final FragmentShowPostBinding fragmentShowPostBinding = FragmentShowPostBinding.inflate(inflater, parent, false);

        //set adapter for comments recycler view (if we implement this feature eventually)

        itemPostViewModel.init(post, this.getContext().getApplicationContext());

        itemPostViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    fragmentShowPostBinding.setItemPostViewModel(itemPostViewModel);
                } else {
                    Toast.makeText(getContext(), "Server Error", Toast.LENGTH_SHORT);
                }
            }
        });

        return fragmentShowPostBinding.getRoot();
    }

    public void setPost(Post post) {
        this.post = post;
    }

}
