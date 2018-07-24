package com.example.asus.example.mvvm.View;

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

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentCategoriesEventBinding;
import com.example.asus.example.mvvm.View.Adapter.CategoryAdapter;
import com.example.asus.example.mvvm.ViewModel.CategoryViewModel;

/**
 * Fragment for the view, to show all categories that exist for a event.
 */
public class CategoriesEventFragment extends Fragment implements View.OnClickListener {

    FragmentCategoriesEventBinding fragmentCategoriesEventBinding;
    private CategoryViewModel categoryViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        fragmentCategoriesEventBinding = FragmentCategoriesEventBinding.inflate(inflater, parent, false);
        //set viewmodel
       /* categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        categoryViewModel.setCategoriesToAllCategories();


        //set adapter
        CategoryAdapter categoryAdapter = new CategoryAdapter();
        categoryAdapter.setCategoryList(categoryViewModel.getCategories().getValue());
        fragmentCategoriesEventBinding.categoriesEventCategoryRV.setAdapter(categoryAdapter);
        fragmentCategoriesEventBinding.categoriesEventCategoryRV.setLayoutManager(new LinearLayoutManager(this.getContext()));*/


        View v = inflater.inflate(R.layout.fragment_categories_event, parent, false);


        ////////////////////////
        /*Button b = (Button) v.findViewById(R.id.newEventInCategoryButton);
        b.setOnClickListener(this);*/
        ///////////////////////


        return fragmentCategoriesEventBinding.getRoot();
    }


    public void launchFragment() {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
        navigation_drawer_activity.launchCategoriesEventFragment();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.newEventInCategoryButton:
                launchFragment();
                break;
        }
    }


}
