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

import com.example.asus.example.databinding.FragmentNewGroupInCategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemCategoryViewModel;

/**
 * Activity class for the view regarding creating a new Group in a Category.
 * Uses the ItemCategoryViewModel as its ViewModel.
 */
public class NewGroupInCategoryFragment extends Fragment implements View.OnClickListener {

    private Category chosenCategory;
    private Button button;
    private EditText description;
    private EditText groupName;
    private EditText imageUrl;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        //set viewmodel
        final ItemCategoryViewModel itemCategoryViewModel = ViewModelProviders.of(this).get(ItemCategoryViewModel.class);

        final FragmentNewGroupInCategoryBinding fragmentNewGroupBinding = FragmentNewGroupInCategoryBinding.inflate(inflater, parent, false);

        itemCategoryViewModel.init(chosenCategory, this.getContext().getApplicationContext());

        itemCategoryViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    fragmentNewGroupBinding.setItemCategoryViewModel(itemCategoryViewModel);
                }
            }
        });
        button = fragmentNewGroupBinding.newGroupInCategoryButton;
        button.setOnClickListener(this);
        description = fragmentNewGroupBinding.newGroupInCategoryDescriptionET;
        groupName = fragmentNewGroupBinding.newGroupInCategoryNameET;
        imageUrl = fragmentNewGroupBinding.newGroupInCategoryImageUrlET;


        return fragmentNewGroupBinding.getRoot();
    }


    public void setCategory(Category category) {
        this.chosenCategory = category;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == button.getId()) {
            if (checkIfUserInputFalse()) {
                Toast.makeText(this.getContext(), "Alle Felder müssen ausgefüllt sein!",
                        Toast.LENGTH_SHORT).show();
            } else {
                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchSubcategoriesGroupAndGroupsInCategoryFragment(chosenCategory);
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
