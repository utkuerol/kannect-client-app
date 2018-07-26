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

import com.example.asus.example.databinding.FragmentMyGroupsBinding;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.GroupAdapter;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerGroup;
import com.example.asus.example.mvvm.ViewModel.GroupViewModel;

/**
 * Fragment for the view, to show all groups in which the user is a member of.
 */
public class MyGroupsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        //set viewmodel
        final GroupViewModel groupViewModel = ViewModelProviders.of(this).get(GroupViewModel.class);
        groupViewModel.init(getContext().getApplicationContext());

        //set adapter
        final GroupAdapter groupAdapter = new GroupAdapter();
        OnItemClickListenerGroup listener = new OnItemClickListenerGroup() {
            @Override
            public void onItemClick(Group group) {

                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchGroupFeedFragment(group);

            }
        };
        groupAdapter.setListener(listener);

        //set databinding
        final FragmentMyGroupsBinding fragmentMyGroupsBinding = FragmentMyGroupsBinding.inflate(inflater, parent, false);
        fragmentMyGroupsBinding.myGroupsGroupRV.setAdapter(groupAdapter);


        groupViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    groupViewModel.setGroupsToJoinedGroups();
                    groupAdapter.setGroupList(groupViewModel.getGroups().getValue());
                    fragmentMyGroupsBinding.myGroupsGroupRV.setAdapter(groupAdapter);

                }
            }
        });

        fragmentMyGroupsBinding.myGroupsGroupRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return fragmentMyGroupsBinding.getRoot();
    }


}
