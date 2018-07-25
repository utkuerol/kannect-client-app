package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentMyGroupsBinding;
import com.example.asus.example.mvvm.Interfaces.OnItemClickListenerGroup;
import com.example.asus.example.mvvm.Model.Entities.Group;
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
        // Defines the xml file for the fragment

        //set viewmodel
        groupViewModel = ViewModelProviders.of(this).get(GroupViewModel.class);
        /*keine Ahnung welche Query*/
        groupViewModel.setGroupsToJoinedGroups();

        //set adapter
        GroupAdapter groupAdapter = new GroupAdapter();
        OnItemClickListenerGroup listener = new OnItemClickListenerGroup() {
            @Override
            public void onItemClick(Group group) {

                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchGroupFeedFragment(group);

            }
        };
        groupAdapter.setListener(listener);
        groupAdapter.setGroupList(groupViewModel.getGroups().getValue());
        fragmentMyGroupsBinding.myGroupsGroupRV.setAdapter(groupAdapter);
        fragmentMyGroupsBinding.myGroupsGroupRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //TODO: observe livedata somehow
        return inflater.inflate(R.layout.fragment_my_groups, parent, false);
    }


}
