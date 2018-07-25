package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentCategoriesEventBinding;
import com.example.asus.example.mvvm.Interfaces.OnItemClickListenerCategory;
import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.View.Adapter.CategoryAdapter;
import com.example.asus.example.mvvm.ViewModel.CategoryViewModel;
import com.example.asus.example.mvvm.ViewModel.ItemCategoryViewModel;

import java.util.List;

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
        categoryViewModel.setCategoriesToAllCategories();

        //set adapter
        CategoryAdapter categoryAdapter = new CategoryAdapter();
        OnItemClickListenerCategory listener = new OnItemClickListenerCategory() {
            @Override
            public void onItemClick(Category item) {
                Toast.makeText(getActivity(), "Item clicked: " + item.getName(), Toast.LENGTH_SHORT).show();

                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchSubcategoriesEventAndEventsInCategoryFragment(item);

            }
        };
        categoryAdapter.setListener(listener);
        categoryAdapter.setCategoryList(categoryViewModel.getCategories().getValue());
        fragmentCategoriesEventBinding.categoriesEventCategoryRV.setAdapter(categoryAdapter);
        fragmentCategoriesEventBinding.categoriesEventCategoryRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
        View v = inflater.inflate(R.layout.fragment_categories_event, parent, false);
        return v;
    }


    ////////////////////////
        /*Button b = (Button) v.findViewById(R.id.newEventInCategoryButton);
        b.setOnClickListener(this);
    ///////////////////////
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.newEventInCategoryButton:
                launchFragment();
                break;
        }
    }
        */

}
