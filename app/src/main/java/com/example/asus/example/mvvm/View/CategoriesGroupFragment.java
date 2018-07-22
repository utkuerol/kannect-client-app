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
import com.example.asus.example.databinding.FragmentCategoriesGroupBinding;
import com.example.asus.example.mvvm.View.Adapter.CategoryAdapter;
import com.example.asus.example.mvvm.ViewModel.CategoryViewModel;

/**
 * Fragment for the view, to show all categories that exist for a group.
 */
public class CategoriesGroupFragment extends Fragment{

    private CategoryViewModel categoryViewModel;
    private FragmentCategoriesGroupBinding fragmentCategoriesGroupBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_categories_group, parent, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        //set viewmodel
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        categoryViewModel.setCategoriesToAllCategories();

        //set adapter
        CategoryAdapter categoryAdapter = new CategoryAdapter();
        categoryAdapter.setCategoryList(categoryViewModel.getCategories().getValue());
        fragmentCategoriesGroupBinding.groupFeedRV.setAdapter(categoryAdapter);
        fragmentCategoriesGroupBinding.groupFeedRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //TODO: observe livedata somehow

    }
}
