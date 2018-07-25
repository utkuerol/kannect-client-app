package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.databinding.FragmentNewGroupInSubcategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.ViewModel.GroupViewModel;

/**
 * Activity class for the view regarding creating a new Group in a Subcategory.
 * Uses the ItemSubcategoryView as its ViewModel.
 */
public class NewGroupInSubcategoryFragment extends Fragment {

    private Subcategory subcategory;
    private GroupViewModel groupViewModel;
    private FragmentNewGroupInSubcategoryBinding fragmentNewGroupBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        fragmentNewGroupBinding = FragmentNewGroupInSubcategoryBinding.inflate(inflater, parent, false);
        //set viewmodel
        groupViewModel = ViewModelProviders.of(this).get(GroupViewModel.class);
        // Defines the xml file for the fragment
        return fragmentNewGroupBinding.getRoot();
    }

    public void launchFragment() {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
        navigation_drawer_activity.launchNewGroupInSubcategoryFragment();
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
}
