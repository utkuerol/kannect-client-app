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
import com.example.asus.example.databinding.FragmentGroupFeedBinding;
import com.example.asus.example.mvvm.View.Adapter.EventAdapter;
import com.example.asus.example.mvvm.View.Adapter.GroupAdapter;
import com.example.asus.example.mvvm.ViewModel.EventViewModel;
import com.example.asus.example.mvvm.ViewModel.GroupViewModel;

/**
 * Activity displaying informations about the group and its posts
 */
public class GroupFeedFragment extends Fragment {
    private GroupViewModel groupViewModel;
    private FragmentGroupFeedBinding fragmentGroupFeedBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_group_feed, parent, false);
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
        fragmentGroupFeedBinding.groupFeedRV.setAdapter(groupAdapter);
        fragmentGroupFeedBinding.groupFeedRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //TODO: observe livedata somehow

    }

}
