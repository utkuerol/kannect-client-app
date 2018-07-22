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
import com.example.asus.example.databinding.FragmentNewGroupBinding;
import com.example.asus.example.mvvm.ViewModel.EventViewModel;
import com.example.asus.example.mvvm.ViewModel.GroupViewModel;

/**
 * Activity class for the view regarding creating a new Group in a Category.
 * Uses the ItemCategoryViewModel as its ViewModel.
 */
public class NewGroupInCategoryFragment extends Fragment {
    private GroupViewModel groupViewModel;
    private FragmentNewGroupBinding FragmentNewGroupBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_new_group, parent, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        //set viewmodel
        groupViewModel = ViewModelProviders.of(this).get(GroupViewModel.class);

        //groupViewModel.add(null);


        //TODO: observe livedata somehow

    }
}
