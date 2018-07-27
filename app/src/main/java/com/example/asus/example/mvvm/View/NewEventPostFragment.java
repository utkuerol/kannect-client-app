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

import com.example.asus.example.databinding.FragmentNewEventPostBinding;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemEventViewModel;

public class NewEventPostFragment extends Fragment implements View.OnClickListener {

    private Event event;
    private Button button;
    private EditText description;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        final FragmentNewEventPostBinding fragmentNewEventPostBinding = FragmentNewEventPostBinding.inflate(inflater, parent, false);

        //set viewmodel
        final ItemEventViewModel itemEventViewModel = ViewModelProviders.of(this).get(ItemEventViewModel.class);
        itemEventViewModel.init(event, this.getContext().getApplicationContext());

        itemEventViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    fragmentNewEventPostBinding.setItemEventViewModel(itemEventViewModel);
                } else {
                    Toast.makeText(getContext(), "Server Error", Toast.LENGTH_SHORT);
                }
            }
        });
        button = fragmentNewEventPostBinding.button;
        button.setOnClickListener(this);
        description = fragmentNewEventPostBinding.newEventPostET;

        return fragmentNewEventPostBinding.getRoot();
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == button.getId()) {
            if (description.getText().toString().length() == 0) {
                Toast.makeText(this.getContext(), "Du musst ein Text für den Beitrag eingeben!",
                        Toast.LENGTH_SHORT).show();
            } else {
                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchEventFeedFragment(event);
            }
        }
    }
}
