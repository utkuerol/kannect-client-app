package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asus.example.databinding.FragmentNewGroupInCategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemCategoryViewModel;

/**
 * Activity class for the view regarding creating a new Group in a Category.
 * Uses the ItemCategoryViewModel as its ViewModel.
 */
public class NewGroupInCategoryFragment extends Fragment {

    private Category chosenCategory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        //set viewmodel
        final ItemCategoryViewModel itemCategoryViewModel = ViewModelProviders.of(this).get(ItemCategoryViewModel.class);

        final FragmentNewGroupInCategoryBinding fragmentNewGroupBinding = FragmentNewGroupInCategoryBinding.inflate(inflater, parent, false);

        itemCategoryViewModel.init(chosenCategory, this.getContext().getApplicationContext());

        itemCategoryViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    fragmentNewGroupBinding.setItemCategoryViewModel(itemCategoryViewModel);
                } else {
                    Toast.makeText(getContext(), "Server Error", Toast.LENGTH_SHORT);
                }
            }
        });

        return fragmentNewGroupBinding.getRoot();
    }


    public void setCategory(Category category) {
        this.chosenCategory = category;
    }
}
