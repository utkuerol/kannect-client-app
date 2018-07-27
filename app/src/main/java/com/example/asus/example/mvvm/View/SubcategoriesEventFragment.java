package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentSubcategoriesEventBinding;
import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerSubcategory;
import com.example.asus.example.mvvm.View.Adapter.SubcategoryAdapter;
import com.example.asus.example.mvvm.ViewModel.ItemCategoryViewModel;

/**
 * Fragment for the view, to show all the subcategories that exist for a event.
 */
public class SubcategoriesEventFragment extends Fragment implements View.OnClickListener {
    private FragmentSubcategoriesEventBinding fragmentSubcategoriesEventBinding;
    private Category category;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        fragmentSubcategoriesEventBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_subcategories_event, parent, false);

        //set viewmodel
        final ItemCategoryViewModel itemCategoryViewModel = ViewModelProviders.of(this).get(ItemCategoryViewModel.class);

        //set adapter
        final SubcategoryAdapter subcategoryAdapter = new SubcategoryAdapter();
        OnItemClickListenerSubcategory listener = new OnItemClickListenerSubcategory() {
            @Override
            public void onItemClick(Subcategory subcategory) {

                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchEventsInSubcategoryFragment(subcategory);

            }
        };
        subcategoryAdapter.setListener(listener);

        //set databinding
        ImageView newEventInCategoryButton = (ImageView) fragmentSubcategoriesEventBinding.newEventInCategoryButton;
        newEventInCategoryButton.setOnClickListener(this);
        fragmentSubcategoriesEventBinding.subcategoriesEventSubcategoryRV.setAdapter(subcategoryAdapter);


        itemCategoryViewModel.init(category, this.getContext().getApplicationContext());

        itemCategoryViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    subcategoryAdapter.setSubcategoryList(itemCategoryViewModel.getSubcategories());
                    fragmentSubcategoriesEventBinding.subcategoriesEventSubcategoryRV.setAdapter(subcategoryAdapter);
                }
            }
        });

        fragmentSubcategoriesEventBinding.newEventInCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchNewEventInCategoryFragment(category);
            }
        });


        fragmentSubcategoriesEventBinding.subcategoriesEventSubcategoryRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return fragmentSubcategoriesEventBinding.getRoot();
    }


    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public void onClick(View v) {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
        switch (v.getId()) {
            case R.id.newEventInCategoryButton:
                // welche Fragment sollte hinzugefügt werden navigation_drawer_activity.launchNewEventInSubategoryFragment();
                break;
        }
    }

}
