package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentGroupsInSubcategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.View.Adapter.GroupAdapter;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerGroup;
import com.example.asus.example.mvvm.ViewModel.GroupViewModel;

/**
 * Activity class for the view regarding showing subcategories and the groups which belong to the parent category.
 */
public class GroupsInSubcategoryFragment extends Fragment {
    private Subcategory subcategory;
    private GroupViewModel groupViewModel;
    private FragmentGroupsInSubcategoryBinding fragmentGroupsInSubcategory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        //set viewmodel
        groupViewModel = ViewModelProviders.of(this).get(GroupViewModel.class);
        groupViewModel.init(getContext());
        groupViewModel.setGroupsFilteredBySubcategory(subcategory);

        //set adapter
        GroupAdapter groupAdapter = new GroupAdapter();
        OnItemClickListenerGroup listener = new OnItemClickListenerGroup() {
            @Override
            public void onItemClick(Group item) {
                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchGroupFeedFragment(item);
            }
        };
        groupAdapter.setListener(listener);
        groupAdapter.setGroupList(groupViewModel.getGroups().getValue());
        fragmentGroupsInSubcategory.groupsInSubcategoryGroupRV.setAdapter(groupAdapter);
        fragmentGroupsInSubcategory.groupsInSubcategoryGroupRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_groups_in_subcategory, parent, false);
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
}
