package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.databinding.FragmentNewEventPostBinding;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemEventViewModel;

public class NewEventPostFragment extends Fragment {

    private Event event;


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
                }
            }
        });

        return fragmentNewEventPostBinding.getRoot();
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
