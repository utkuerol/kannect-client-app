package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
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
import com.example.asus.example.databinding.FragmentCategoriesGroupBinding;
import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.View.Adapter.CategoryAdapter;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerCategory;
import com.example.asus.example.mvvm.ViewModel.CategoryViewModel;

import java.util.List;

/**
 * Fragment for the view, to show all categories that exist for a group.
 */
public class CategoriesGroupFragment extends Fragment {

    private CategoryViewModel categoryViewModel;
    private FragmentCategoriesGroupBinding fragmentCategoriesGroupBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        fragmentCategoriesGroupBinding = FragmentCategoriesGroupBinding.inflate(inflater, parent, false);
        //set viewmodel
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        categoryViewModel.init();
        categoryViewModel.setCategoriesToAllCategories();

        //set adapter
        final CategoryAdapter categoryAdapter = new CategoryAdapter();
        OnItemClickListenerCategory listener = new OnItemClickListenerCategory() {
            @Override
            public void onItemClick(Category item) {
                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchSubcategoriesEventAndEventsInCategoryFragment(item);

            }
        };
        categoryAdapter.setListener(listener);


        categoryViewModel.getCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(@Nullable List<Category> categories) {
                if (categories != null) {
                    categoryAdapter.setCategoryList(categoryViewModel.getCategories().getValue());
                    fragmentCategoriesGroupBinding.categoriesGroupCategoryRV.setAdapter(categoryAdapter);
                }
            }
        });

        fragmentCategoriesGroupBinding.categoriesGroupCategoryRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return fragmentCategoriesGroupBinding.getRoot();
    }

}