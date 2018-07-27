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

import com.example.asus.example.databinding.FragmentNewEventInSubcategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemSubcategoryViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Activity class for the view of creating a new Event in a Subcategory.
 * Uses the ItemSubcategoryViewModel as its ViewModel.
 */
public class NewEventInSubcategoryFragment extends Fragment implements View.OnClickListener {

    private Subcategory subcategory;
    private Button button;
    private EditText description;
    private EditText eventName;
    private EditText imageUrl;
    private EditText eventDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        final FragmentNewEventInSubcategoryBinding fragmentNewEventInSubcategoryBinding = FragmentNewEventInSubcategoryBinding.inflate(inflater, parent, false);

        //set viewmodel
        final ItemSubcategoryViewModel itemSubcategoryViewModel = ViewModelProviders.of(this).get(ItemSubcategoryViewModel.class);
        itemSubcategoryViewModel.init(subcategory, this.getContext().getApplicationContext());

        itemSubcategoryViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    fragmentNewEventInSubcategoryBinding.setItemSubcategoryViewModel(itemSubcategoryViewModel);
                } else {
                    Toast.makeText(getContext(), "Server Error", Toast.LENGTH_SHORT);
                }
            }
        });

        button = fragmentNewEventInSubcategoryBinding.newEventInSubcategoryButton;
        button.setOnClickListener(this);

        description = fragmentNewEventInSubcategoryBinding.newEventInSubcategoryDescriptionET;
        eventName = fragmentNewEventInSubcategoryBinding.newEventInSubcategoryNameET;
        eventDate = fragmentNewEventInSubcategoryBinding.newEventInSubcategoryDate;
        imageUrl = fragmentNewEventInSubcategoryBinding.newEventInSubcategoryImageUrlET;

        return fragmentNewEventInSubcategoryBinding.getRoot();
    }


    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == button.getId()) {
            if (checkIfInputIsFalse() && !checkIfDateIsValid()) {
                Toast.makeText(this.getContext(), "Alle Felder müssen richtig ausgefüllt sein!",
                        Toast.LENGTH_SHORT).show();
            } else {
                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchEventsInSubcategoryFragment(subcategory);
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
