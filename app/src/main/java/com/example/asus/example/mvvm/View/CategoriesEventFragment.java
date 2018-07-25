package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentCategoriesEventBinding;
import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.View.Adapter.CategoryAdapter;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerCategory;
import com.example.asus.example.mvvm.ViewModel.CategoryViewModel;

/**
 * Fragment for the view, to show all categories that exist for a event.
 */
public class CategoriesEventFragment extends Fragment {

    FragmentCategoriesEventBinding fragmentCategoriesEventBinding;
    private CategoryViewModel categoryViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        fragmentCategoriesEventBinding = FragmentCategoriesEventBinding.inflate(inflater, parent, false);

        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        categoryViewModel.init();
        categoryViewModel.setCategoriesToAllCategories();

        //set adapter
        CategoryAdapter categoryAdapter = new CategoryAdapter();
        OnItemClickListenerCategory listener = new OnItemClickListenerCategory() {
            @Override
            public void onItemClick(Category item) {
                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchSubcategoriesEventAndEventsInCategoryFragment(item);

            }
        };
        categoryAdapter.setListener(listener);
        categoryAdapter.setCategoryList(categoryViewModel.getCategories().getValue());
        fragmentCategoriesEventBinding.categoriesEventCategoryRV.setAdapter(categoryAdapter);
        fragmentCategoriesEventBinding.categoriesEventCategoryRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return inflater.inflate(R.layout.fragment_categories_event, parent, false);


    }


}
