package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentGroupsInSubcategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.GroupAdapter;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerGroup;
import com.example.asus.example.mvvm.ViewModel.GroupViewModel;


/**
 * Activity class for the view regarding showing subcategories and the groups which belong to the parent category.
 */
public class GroupsInSubcategoryFragment extends Fragment implements View.OnClickListener {

    private Subcategory subcategory;
    private FragmentGroupsInSubcategoryBinding fragmentGroupsInSubcategoryBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        fragmentGroupsInSubcategoryBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_groups_in_subcategory, parent, false);
        //set viewmodel
        final GroupViewModel groupViewModel = ViewModelProviders.of(this).get(GroupViewModel.class);
        groupViewModel.init(getContext());
        groupViewModel.setGroupsFilteredBySubcategory(subcategory);


        //set adapter
        final GroupAdapter groupAdapter = new GroupAdapter();
        OnItemClickListenerGroup listener = new OnItemClickListenerGroup() {
            @Override
            public void onItemClick(Group item) {
                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchGroupFeedFragment(item);
            }
        };
        groupAdapter.setListener(listener);

        fragmentGroupsInSubcategoryBinding.groupsInSubcategoryGroupRV.setAdapter(groupAdapter);


        groupViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    groupAdapter.setGroupList(groupViewModel.getGroups().getValue());
                    fragmentGroupsInSubcategoryBinding.groupsInSubcategoryGroupRV.setAdapter(groupAdapter);

                }
            }
        });

        ImageView groupsInSubcategoryCreateGroupIV = (ImageView) fragmentGroupsInSubcategoryBinding.groupsInSubcategoryCreateGroupIV;
        groupsInSubcategoryCreateGroupIV.setOnClickListener(this);

        fragmentGroupsInSubcategoryBinding.groupsInSubcategoryGroupRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return fragmentGroupsInSubcategoryBinding.getRoot();
    }

    @Override
    public void onClick(View v) {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
        switch (v.getId()) {
            case R.id.groupsInSubcategoryCreateGroupIV:
                Log.d("rrrrrrrrrr", "rrrrrrrrrrrrrr");
                navigation_drawer_activity.launchNewGroupInSubcategoryFragment(subcategory);
                break;
        }
    }


    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
}
