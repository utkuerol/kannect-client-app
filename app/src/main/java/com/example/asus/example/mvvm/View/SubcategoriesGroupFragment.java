package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentSubcategoriesGroupBinding;
import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerSubcategory;
import com.example.asus.example.mvvm.View.Adapter.SubcategoryAdapter;
import com.example.asus.example.mvvm.ViewModel.ItemCategoryViewModel;

/**
 * Fragment for the view, to show all the subcategories that exist for a group.
 */
public class SubcategoriesGroupFragment extends Fragment {

    private Category category;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        //get extra arguments from the initiating activity
        Category category = (Category) getArguments().getSerializable("category");

        //set viewmodel
        ItemCategoryViewModel itemCategoryViewModel = ViewModelProviders.of(this).get(ItemCategoryViewModel.class);
        itemCategoryViewModel.init(category, getContext());

        //set adapter
        SubcategoryAdapter subcategoryAdapter = new SubcategoryAdapter();
        OnItemClickListenerSubcategory listener = new OnItemClickListenerSubcategory() {
            @Override
            public void onItemClick(Subcategory subcategory) {

                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchGroupsInSubcategoryFragment(subcategory);

            }
        };
        subcategoryAdapter.setListener(listener);
        subcategoryAdapter.setSubcategoryList(itemCategoryViewModel.getSubcategories());

        //set databinding
        FragmentSubcategoriesGroupBinding fragmentSubcategoriesGroupBinding = FragmentSubcategoriesGroupBinding.inflate(inflater, parent, false);
        fragmentSubcategoriesGroupBinding.subcategoriesGroupSubcategoriesRV.setAdapter(subcategoryAdapter);
        fragmentSubcategoriesGroupBinding.subcategoriesGroupSubcategoriesRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //TODO: observe livedata somehow

        return inflater.inflate(R.layout.fragment_subcategories_group, parent, false);

    }


    public void setCategory(Category category) {
        this.category = category;
    }
}
