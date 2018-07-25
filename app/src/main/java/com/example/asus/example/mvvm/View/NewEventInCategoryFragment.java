package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.databinding.FragmentNewEventInCategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.ViewModel.EventViewModel;

/**
 * Activity class for the view regarding creating a new Event in a Category.
 * Uses the ItemCategoryViewModel as its ViewModel.
 */
public class NewEventInCategoryFragment extends Fragment {
    private Category category;
    private EventViewModel eventViewModel;
    private FragmentNewEventInCategoryBinding fragmentNewEventBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        fragmentNewEventBinding = FragmentNewEventInCategoryBinding.inflate(inflater, parent, false);
        //set viewmodel
        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        // Defines the xml file for the fragment
        return fragmentNewEventBinding.getRoot();
    }

    public void launchFragment() {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
        navigation_drawer_activity.launchNewEventInCategoryFragment();
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
