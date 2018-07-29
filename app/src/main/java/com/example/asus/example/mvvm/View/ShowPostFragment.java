package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentShowPostBinding;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemPostViewModel;

/**
 * Activity class for the view regarding showing a Post and its comments.
 * Uses the ItemPostViewModel as its ViewModel.
 */
public class ShowPostFragment extends Fragment implements View.OnClickListener {

    private FragmentShowPostBinding fragmentShowPostBinding;
    private ItemPostViewModel itemPostViewModel;
    private Post post;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        fragmentShowPostBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_show_post, parent, false);

        //set viewmodel
        itemPostViewModel = ViewModelProviders.of(this).get(ItemPostViewModel.class);

        //set databinding


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
        ImageView deleteView = (ImageView) fragmentShowPostBinding.imageView2;
        deleteView.setOnClickListener(this);

        return fragmentShowPostBinding.getRoot();
    }

    @Override
    public void onClick(View v) {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();

        switch (v.getId()) {
            case R.id.imageView2:
                itemPostViewModel.deletePost();
        }
    }

    public void setPost(Post post) {
        this.post = post;
    }

}
