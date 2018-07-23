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
import com.example.asus.example.databinding.FragmentCategoriesEventBinding;
import com.example.asus.example.mvvm.View.Adapter.CategoryAdapter;
import com.example.asus.example.mvvm.ViewModel.CategoryViewModel;

/**
 * Fragment for the view, to show all categories that exist for a event.
 */
public class CategoriesEventFragment extends Fragment {

    FragmentCategoriesEventBinding fragmentCategoriesEventBinding;
    private CategoryViewModel categoryViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        //set viewmodel
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        categoryViewModel.setCategoriesToAllCategories();
        fragmentCategoriesEventBinding = FragmentCategoriesEventBinding.inflate(inflater, parent, false);

        //set adapter
        CategoryAdapter categoryAdapter = new CategoryAdapter();
        categoryAdapter.setCategoryList(categoryViewModel.getCategories().getValue());
        fragmentCategoriesEventBinding.categoriesEventCategoryRV.setAdapter(categoryAdapter);
        fragmentCategoriesEventBinding.categoriesEventCategoryRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return fragmentCategoriesEventBinding.getRoot();
    }

}
