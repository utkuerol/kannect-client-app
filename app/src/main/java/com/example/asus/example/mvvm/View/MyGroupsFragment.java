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
import com.example.asus.example.databinding.FragmentMyGroupsBinding;
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
        return inflater.inflate(R.layout.fragment_groups_in_subcategory, parent, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        //set viewmodel
        groupViewModel = ViewModelProviders.of(this).get(GroupViewModel.class);
        /*keine Ahnung welche Query*/
        groupViewModel.setGroupsToJoinedGroups(null);

        //set adapter
        GroupAdapter groupAdapter = new GroupAdapter();
        groupAdapter.setGroupList(groupViewModel.getGroups().getValue());
        fragmentMyGroupsBinding.myGroupsRV.setAdapter(groupAdapter);
        fragmentMyGroupsBinding.myGroupsRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //TODO: observe livedata somehow

    }
}
