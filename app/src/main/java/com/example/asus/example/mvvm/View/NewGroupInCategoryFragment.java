package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.databinding.FragmentNewGroupInCategoryBinding;
import com.example.asus.example.mvvm.ViewModel.GroupViewModel;

/**
 * Activity class for the view regarding creating a new Group in a Category.
 * Uses the ItemCategoryViewModel as its ViewModel.
 */
public class NewGroupInCategoryFragment extends Fragment {
    private GroupViewModel groupViewModel;
    private FragmentNewGroupInCategoryBinding fragmentNewGroupBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        fragmentNewGroupBinding = FragmentNewGroupInCategoryBinding.inflate(inflater, parent, false);
        //set viewmodel
        groupViewModel = ViewModelProviders.of(this).get(GroupViewModel.class);
        // Defines the xml file for the fragment
        return fragmentNewGroupBinding.getRoot();
    }

    public void launchFragment() {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
        navigation_drawer_activity.launchNewGroupInCategoryFragment();
    }

}
