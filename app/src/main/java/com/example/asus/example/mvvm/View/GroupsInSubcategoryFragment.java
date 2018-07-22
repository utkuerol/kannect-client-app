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
import com.example.asus.example.databinding.FragmentGroupsInSubacategoryBinding;
import com.example.asus.example.mvvm.View.Adapter.GroupAdapter;
import com.example.asus.example.mvvm.ViewModel.GroupViewModel;

/**
 * Activity class for the view regarding showing subcategories and the groups which belong to the parent category.
 */
public class GroupsInSubcategoryFragment extends Fragment {

    private GroupViewModel groupViewModel;
    private FragmentGroupsInSubacategoryBinding fragmentGroupsInSubcategory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_groups_in_subacategory, parent, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        //set viewmodel
        groupViewModel = ViewModelProviders.of(this).get(GroupViewModel.class);
        /*keine Ahnung welche Query*/
        groupViewModel.setGroupsFilteredBySubcategory(null);

        //set adapter
        GroupAdapter groupAdapter = new GroupAdapter();
        groupAdapter.setGroupList(groupViewModel.getGroups().getValue());
        fragmentGroupsInSubcategory.groupsInSubcategoryRV.setAdapter(groupAdapter);
        fragmentGroupsInSubcategory.groupsInSubcategoryRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //TODO: observe livedata somehow

    }
}
