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
import com.example.asus.example.databinding.FragmentMyGroupsBinding;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.GroupAdapter;
import com.example.asus.example.mvvm.ViewModel.GroupViewModel;

/**
 * Fragment for the view, to show all groups in which the user is a member of.
 */
public class MyGroupsFragment extends Fragment {

    private GroupViewModel groupViewModel;
    private FragmentMyGroupsBinding fragmentMyGroupsBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        User user = (User) getArguments().getSerializable("user");

        fragmentMyGroupsBinding = FragmentMyGroupsBinding.inflate(inflater, parent, false);
        //set viewmodel
        groupViewModel = ViewModelProviders.of(this).get(GroupViewModel.class);
        /*keine Ahnung welche Query*/
        groupViewModel.setGroupsToJoinedGroups(user);
        //set adapter
        GroupAdapter groupAdapter = new GroupAdapter();
        groupAdapter.setGroupList(groupViewModel.getGroups().getValue());
        fragmentMyGroupsBinding.myGroupsGroupRV.setAdapter(groupAdapter);
        fragmentMyGroupsBinding.myGroupsGroupRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
        // Defines the xml file for the fragment
        return fragmentMyGroupsBinding.getRoot();
    }

}
