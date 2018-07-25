package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.databinding.FragmentNewEventInSubcategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemSubcategoryViewModel;

/**
 * Activity class for the view of creating a new Event in a Subcategory.
 * Uses the ItemSubcategoryViewModel as its ViewModel.
 */
public class NewEventInSubcategoryFragment extends Fragment {

    private Subcategory subcategory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        final FragmentNewEventInSubcategoryBinding fragmentNewEventInSubcategoryBinding = FragmentNewEventInSubcategoryBinding.inflate(inflater, parent, false);

        //set viewmodel
        final ItemSubcategoryViewModel itemSubcategoryViewModel = ViewModelProviders.of(this).get(ItemSubcategoryViewModel.class);
        itemSubcategoryViewModel.init(subcategory, this.getContext().getApplicationContext());

        itemSubcategoryViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    fragmentNewEventInSubcategoryBinding.setItemSubcategoryViewModel(itemSubcategoryViewModel);
                }
            }
        });
        return fragmentNewEventInSubcategoryBinding.getRoot();
    }


    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
}
