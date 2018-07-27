package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

import java.util.List;

/**
 * Fragment for the view, to show all categories that exist for a event.
 */
public class CategoriesEventFragment extends Fragment {

    FragmentCategoriesEventBinding fragmentCategoriesEventBinding;
    private CategoryViewModel categoryViewModel;

    /**
     * Method which will be called when this fragment is created.
     * Inflates the View, sets the ViewModel and the Adapter with the right onClickListener for the
     * RecyclerView.
     *
     * @param inflater           inflates the layout on the screen
     * @param parent             of this ViewGroup
     * @param savedInstanceState state of the Application as a Bundle
     * @return the outermost View in the layout file associated with the Binding.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        fragmentCategoriesEventBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_categories_event, parent, false);

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
                    fragmentCategoriesEventBinding.categoriesEventCategoryRV.setAdapter(categoryAdapter);
                }
            }
        });


        fragmentCategoriesEventBinding.categoriesEventCategoryRV.setAdapter(categoryAdapter);
        fragmentCategoriesEventBinding.categoriesEventCategoryRV.setLayoutManager(new LinearLayoutManager(this.getContext()));


        return fragmentCategoriesEventBinding.getRoot();


    }




}
