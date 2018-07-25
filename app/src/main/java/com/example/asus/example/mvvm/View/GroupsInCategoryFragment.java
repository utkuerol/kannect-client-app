package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentGroupsInCategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.View.Adapter.GroupAdapter;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerGroup;
import com.example.asus.example.mvvm.ViewModel.GroupViewModel;

/**
 * Fragment for the view, to show all groups that exist in the chosen Category.
 */
public class GroupsInCategoryFragment extends Fragment {
    private Category category;
    private GroupViewModel groupViewModel;
    private FragmentGroupsInCategoryBinding fragmentGroupsInCategoryBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        fragmentGroupsInCategoryBinding = FragmentGroupsInCategoryBinding.inflate(inflater, parent, false);

        //set viewmodel
        groupViewModel = ViewModelProviders.of(this).get(GroupViewModel.class);
        groupViewModel.init(getContext());
        groupViewModel.setGroupsFilteredByCategory(category);

        //set adapter
        GroupAdapter groupAdapter = new GroupAdapter();
        OnItemClickListenerGroup listener = new OnItemClickListenerGroup() {
            @Override
            public void onItemClick(Group item) {
                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchGroupFeedFragment(item);
            }
        };
        groupAdapter.setGroupList(groupViewModel.getGroups().getValue());
        fragmentGroupsInCategoryBinding.groupsInCategoryGroupRV.setAdapter(groupAdapter);
        fragmentGroupsInCategoryBinding.groupsInCategoryGroupRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_groups_in_category, parent, false);
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
