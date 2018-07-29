package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.databinding.FragmentNewGroupInSubcategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemSubcategoryViewModel;

/**
 * Activity class for the view regarding creating a new Group in a Subcategory.
 * Uses the ItemSubcategoryViewModel as its ViewModel.
 */
public class NewGroupInSubcategoryFragment extends Fragment {

    private Subcategory subcategory;


    /**
     * Method which will be called when this fragment is created.
     * Inflates the View and sets the ViewModel.
     * Observes getCurrentUser to check if there is a value or a null object.
     * @param inflater           inflates the layout on the screen
     * @param parent             of this ViewGroup
     * @param savedInstanceState state of the Application as a Bundle
     * @return the outermost View in the layout file associated with the Binding.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


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

    /**
     * sets the subcategory in which the User wants to create a Group in.
     * @param subcategory chosen by User.
     */
    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }


}
