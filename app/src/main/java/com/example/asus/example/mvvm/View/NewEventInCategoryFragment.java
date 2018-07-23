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
import com.example.asus.example.databinding.FragmentNewEventBinding;
import com.example.asus.example.mvvm.View.Adapter.GroupAdapter;
import com.example.asus.example.mvvm.ViewModel.EventViewModel;
import com.example.asus.example.mvvm.ViewModel.GroupViewModel;

/**
 * Activity class for the view regarding creating a new Event in a Category.
 * Uses the ItemCategoryViewModel as its ViewModel.
 */
public class NewEventInCategoryFragment extends Fragment {

    private EventViewModel eventViewModel;
    private FragmentNewEventBinding fragmentNewEventBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        fragmentNewEventBinding = FragmentNewEventBinding.inflate(inflater, parent, false);
        //set viewmodel
        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        // Defines the xml file for the fragment
        return fragmentNewEventBinding.getRoot();
    }

}
