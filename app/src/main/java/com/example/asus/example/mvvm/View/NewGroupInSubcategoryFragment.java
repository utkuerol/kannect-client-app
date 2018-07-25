package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.databinding.FragmentNewGroupInSubcategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemSubcategoryViewModel;

/**
 * Activity class for the view regarding creating a new Group in a Subcategory.
 * Uses the ItemSubcategoryViewModel as its ViewModel.
 */
public class NewGroupInSubcategoryFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        //TODO chosen subcategory
        Subcategory subcategory = new Subcategory();

        //set viewmodel
        final ItemSubcategoryViewModel itemSubcategoryViewModel = ViewModelProviders.of(this).get(ItemSubcategoryViewModel.class);

        //set binding
        final FragmentNewGroupInSubcategoryBinding fragmentNewGroupBinding = FragmentNewGroupInSubcategoryBinding.inflate(inflater, parent, false);

        itemSubcategoryViewModel.init(subcategory, this.getContext().getApplicationContext());

        itemSubcategoryViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    fragmentNewGroupBinding.setItemSubcategoryViewModel(itemSubcategoryViewModel);
                }
            }
        });


        return fragmentNewGroupBinding.getRoot();
    }

    public void launchFragment() {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
        navigation_drawer_activity.launchNewGroupInSubcategoryFragment();
    }
}
