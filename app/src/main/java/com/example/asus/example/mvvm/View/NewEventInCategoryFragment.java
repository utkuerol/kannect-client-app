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

import com.example.asus.example.databinding.FragmentNewEventInCategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemCategoryViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Activity class for the view regarding creating a new Event in a Category.
 * Uses the ItemCategoryViewModel as its ViewModel.
 */
public class NewEventInCategoryFragment extends Fragment implements View.OnClickListener {

    private Category chosenCategory;
    private Button button;
    private EditText description;
    private EditText eventName;
    private EditText imageUrl;
    private EditText eventDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        final FragmentNewEventInCategoryBinding fragmentNewEventBinding = FragmentNewEventInCategoryBinding.inflate(inflater, parent, false);

        //set viewmodel
        final ItemCategoryViewModel itemCategoryViewModel = ViewModelProviders.of(this).get(ItemCategoryViewModel.class);
        itemCategoryViewModel.init(chosenCategory, this.getContext().getApplicationContext());

        itemCategoryViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    fragmentNewEventBinding.setItemCategoryViewModel(itemCategoryViewModel);
                } else {
                    Toast.makeText(getContext(), "Server Error", Toast.LENGTH_SHORT);
                }
            }
        });
        button = fragmentNewEventBinding.newEventInCategoryButton;
        button.setOnClickListener(this);

        description = fragmentNewEventBinding.newEventInCategoryDescriptionET;
        eventName = fragmentNewEventBinding.newEventInCategoryNameET;
        eventDate = fragmentNewEventBinding.newEventInCategoryDateET;
        imageUrl = fragmentNewEventBinding.newEventInCategoryImageUrlET;

        return fragmentNewEventBinding.getRoot();
    }


    public void setCategory(Category category) {
        this.chosenCategory = category;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == button.getId()) {
            if (checkIfInputIsFalse() && !checkIfDateIsValid()) {
                Toast.makeText(this.getContext(), "Alle Felder müssen richtig ausgefüllt sein!",
                        Toast.LENGTH_SHORT).show();
            } else {
                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchSubcategoriesEventAndEventsInCategoryFragment(chosenCategory);
            }
        }
    }


    private boolean checkIfInputIsFalse() {
        if (description.getText().toString().length() == 0) {
            return true;
        } else if (imageUrl.getText().toString().length() == 0) {
            return true;
        } else if (eventName.getText().toString().length() == 0) {
            return true;
        }
        return false;
    }

    private boolean checkIfDateIsValid() {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            date = sdf.parse(eventDate.getText().toString());
            if (eventDate.getText().toString().equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }
}
