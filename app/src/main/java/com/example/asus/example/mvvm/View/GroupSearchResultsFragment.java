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
import com.example.asus.example.databinding.FragmentGroupSearchResultBinding;
import com.example.asus.example.mvvm.View.Adapter.GroupAdapter;
import com.example.asus.example.mvvm.ViewModel.GroupViewModel;

public class GroupSearchResultsFragment extends Fragment {

    private GroupViewModel groupViewModel;
    private FragmentGroupSearchResultBinding fragmentGroupSearchResultBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        String query = getArguments().getString("query");
        fragmentGroupSearchResultBinding = FragmentGroupSearchResultBinding.inflate(inflater, parent, false);
        groupViewModel = ViewModelProviders.of(this).get(GroupViewModel.class);
        /*keine Ahnung welche Query*/
        groupViewModel.setGroupsToSearchResults(query);

        //set adapter
        GroupAdapter groupAdapter = new GroupAdapter();
        groupAdapter.setGroupList(groupViewModel.getGroups().getValue());
        fragmentGroupSearchResultBinding.groupSearchResultGroupRV.setAdapter(groupAdapter);
        fragmentGroupSearchResultBinding.groupSearchResultGroupRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
        // Defines the xml file for the fragment
        return fragmentGroupSearchResultBinding.getRoot();
    }

}
