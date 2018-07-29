package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentSubcategoriesGroupBinding;
import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerSubcategory;
import com.example.asus.example.mvvm.View.Adapter.SubcategoryAdapter;
import com.example.asus.example.mvvm.ViewModel.ItemCategoryViewModel;

/**
 * Fragment for the view, to show all the subcategories that exist for a group.
 */
public class SubcategoriesGroupFragment extends Fragment implements View.OnClickListener {

    private Category category;
    private FragmentSubcategoriesGroupBinding fragmentSubcategoriesGroupBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        fragmentSubcategoriesGroupBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_subcategories_group, parent, false);
        //set viewmodel
        final ItemCategoryViewModel itemCategoryViewModel = ViewModelProviders.of(this).get(ItemCategoryViewModel.class);
        itemCategoryViewModel.init(category, this.getContext().getApplicationContext());

        //set adapter
        final SubcategoryAdapter subcategoryAdapter = new SubcategoryAdapter();
        OnItemClickListenerSubcategory listener = new OnItemClickListenerSubcategory() {
            @Override
            public void onItemClick(Subcategory subcategory) {

                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchGroupsInSubcategoryFragment(subcategory);

            }
        };
        subcategoryAdapter.setListener(listener);
        ImageView newGroupInCategoryButton = fragmentSubcategoriesGroupBinding.newGroupInCategoryButton;
        newGroupInCategoryButton.setOnClickListener(this);



        fragmentSubcategoriesGroupBinding.subcategoriesGroupSubcategoriesRV.setAdapter(subcategoryAdapter);

        itemCategoryViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    subcategoryAdapter.setSubcategoryList(itemCategoryViewModel.getSubcategories());
                    fragmentSubcategoriesGroupBinding.subcategoriesGroupSubcategoriesRV.setAdapter(subcategoryAdapter);
                } else {
                    Toast.makeText(getContext(), "Server Error", Toast.LENGTH_SHORT);
                }
            }
        });

        fragmentSubcategoriesGroupBinding.subcategoriesGroupSubcategoriesRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return fragmentSubcategoriesGroupBinding.getRoot();

    }

    @Override
    public void onClick(View v) {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
        switch (v.getId()) {
            case R.id.newGroupInCategoryButton:
                navigation_drawer_activity.launchNewGroupInCategoryFragment(category);
                break;
        }
    }


    public void setCategory(Category category) {
        this.category = category;
    }
}
