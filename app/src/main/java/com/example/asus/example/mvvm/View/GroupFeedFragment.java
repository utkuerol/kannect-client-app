package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.MutableLiveData;
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
import com.example.asus.example.databinding.FragmentGroupFeedBinding;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.GroupAdapter;
import com.example.asus.example.mvvm.View.Adapter.PostAdapter;
import com.example.asus.example.mvvm.ViewModel.GroupViewModel;
import com.example.asus.example.mvvm.ViewModel.ItemGroupViewModel;

/**
 * Activity displaying informations about the group and its posts
 */
public class GroupFeedFragment extends Fragment {
    private Group group;
    private ItemGroupViewModel itemGroupViewModel;
    private FragmentGroupFeedBinding fragmentGroupFeedBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        fragmentGroupFeedBinding = FragmentGroupFeedBinding.inflate(inflater, parent, false);
        //set viewmodel
        itemGroupViewModel = ViewModelProviders.of(this).get(ItemGroupViewModel.class);
        itemGroupViewModel.init(group);



        //set adapter
        PostAdapter postAdapter = new PostAdapter();
        postAdapter.setPostList(itemGroupViewModel.getGroupFeed());
        fragmentGroupFeedBinding.groupFeedPostRV.setAdapter(postAdapter);
        fragmentGroupFeedBinding.groupFeedPostRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_group_feed, parent, false);
    }



    public void setGroup(Group group) {
        this.group = group;
    }
}
