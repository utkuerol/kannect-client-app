package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.example.databinding.FragmentNewGroupInSubcategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemSubcategoryViewModel;

/**
 * Activity class for the view regarding creating a new Group in a Subcategory.
 * Uses the ItemSubcategoryViewModel as its ViewModel.
 */
public class NewGroupInSubcategoryFragment extends Fragment implements View.OnClickListener {

    private Subcategory subcategory;
    private Button button;
    private EditText description;
    private EditText groupName;
    private EditText imageUrl;

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
        button = fragmentNewGroupBinding.newGroupInSubcategoryButton;
        description = fragmentNewGroupBinding.newGroupInSubcategoryDescriptionET;
        groupName = fragmentNewGroupBinding.newGroupInSubcategoryNameET;
        imageUrl = fragmentNewGroupBinding.newGroupInSubcategoryImageUrlET;

        return fragmentNewGroupBinding.getRoot();
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == button.getId()) {
            if (checkIfUserInputFalse()) {
                Toast.makeText(this.getContext(), "Alle Felder müssen ausgefüllt sein!",
                        Toast.LENGTH_SHORT).show();
            } else {
                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchGroupsInSubcategoryFragment(subcategory);
            }
        }
    }

    private boolean checkIfUserInputFalse() {
        if (groupName.getText().toString().length() == 0) {
            return true;
        } else if (description.getText().toString().length() == 0) {
            return true;
        } else if (imageUrl.getText().toString().length() == 0) {
            return true;
        }
        return false;
    }
}
