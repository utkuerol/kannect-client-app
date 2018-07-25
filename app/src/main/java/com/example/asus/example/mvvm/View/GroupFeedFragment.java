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

import com.example.asus.example.databinding.FragmentGroupFeedBinding;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.PostAdapter;
import com.example.asus.example.mvvm.ViewModel.ItemGroupViewModel;

/**
 * Activity displaying informations about the group and its posts
 */
public class GroupFeedFragment extends Fragment {

    private Group group;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        //set viewmodel
        final ItemGroupViewModel itemGroupViewModel = ViewModelProviders.of(this).get(ItemGroupViewModel.class);
        itemGroupViewModel.init(group, getContext());

        //set adapter
        final PostAdapter postAdapter = new PostAdapter();

        //set binding
        final FragmentGroupFeedBinding fragmentGroupFeedBinding = FragmentGroupFeedBinding.inflate(inflater, parent, false);
        fragmentGroupFeedBinding.groupFeedPostRV.setAdapter(postAdapter);


        itemGroupViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    postAdapter.setPostList(itemGroupViewModel.getGroupFeed());
                }
            }
        });

        fragmentGroupFeedBinding.groupFeedPostRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return fragmentGroupFeedBinding.getRoot();
    }


    public void setGroup(Group group) {
        this.group = group;
    }

}
