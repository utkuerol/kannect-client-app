package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.databinding.FragmentNewGroupInCategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemCategoryViewModel;

/**
 * Activity class for the view regarding creating a new Group in a Category.
 * Uses the ItemCategoryViewModel as its ViewModel.
 */
public class NewGroupInCategoryFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        //TODO get chosen category
        final Category chosenCategory = new Category();

        //set viewmodel
        final ItemCategoryViewModel itemCategoryViewModel = ViewModelProviders.of(this).get(ItemCategoryViewModel.class);

        final FragmentNewGroupInCategoryBinding fragmentNewGroupBinding = FragmentNewGroupInCategoryBinding.inflate(inflater, parent, false);

        itemCategoryViewModel.init(chosenCategory, this.getContext().getApplicationContext());

        itemCategoryViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    fragmentNewGroupBinding.setItemCategoryViewModel(itemCategoryViewModel);
                }
            }
        });

        return fragmentNewGroupBinding.getRoot();
    }

    public void launchFragment() {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
        navigation_drawer_activity.launchNewGroupInCategoryFragment();
    }

}
