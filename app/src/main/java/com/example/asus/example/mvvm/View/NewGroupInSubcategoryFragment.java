package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.databinding.FragmentNewGroupInSubcategoryBinding;
import com.example.asus.example.mvvm.ViewModel.GroupViewModel;

/**
 * Activity class for the view regarding creating a new Group in a Subcategory.
 * Uses the ItemSubcategoryViewModel as its ViewModel.
 */
public class NewGroupInSubcategoryFragment extends Fragment {

    private Subcategory subcategory;
    private GroupViewModel groupViewModel;
    private FragmentNewGroupInSubcategoryBinding fragmentNewGroupBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        //TODO chosen subcategory
        Subcategory subcategory = new Subcategory();

        //set viewmodel
        final ItemSubcategoryViewModel itemSubcategoryViewModel = ViewModelProviders.of(this).get(ItemSubcategoryViewModel.class);

        //set binding
        final FragmentNewGroupInSubcategoryBinding fragmentNewGroupBinding = FragmentNewGroupInSubcategoryBinding.inflate(inflater, parent, false);

        itemSubcategoryViewModel.init(subcategory, this.getContext().getApplicationContext());

        itemSubcategoryViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    fragmentNewGroupBinding.setItemSubcategoryViewModel(itemSubcategoryViewModel);
                }
            }
        });


        return fragmentNewGroupBinding.getRoot();
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
}
