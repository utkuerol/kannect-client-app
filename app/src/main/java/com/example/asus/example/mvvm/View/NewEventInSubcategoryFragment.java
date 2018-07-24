package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentNewEventInSubcategoryBinding;
import com.example.asus.example.mvvm.ViewModel.EventViewModel;

/**
 * Activity class for the view of creating a new Event in a Subcategory.
 * Uses the ItemSubcategoryViewModel as its ViewModel.
 */
public class NewEventInSubcategoryFragment extends Fragment {

    private EventViewModel eventViewModel;
    private FragmentNewEventInSubcategoryBinding fragmentNewEventBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        fragmentNewEventBinding = FragmentNewEventInSubcategoryBinding.inflate(inflater, parent, false);
        //set viewmodel
        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        // Defines the xml file for the fragment
        return fragmentNewEventBinding.getRoot();
    }

    public void launchFragment() {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
        navigation_drawer_activity.launchNewEventInSubategoryFragment();
    }


}
