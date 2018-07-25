package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.databinding.FragmentNewPostBinding;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.ViewModel.EventViewModel;

public class NewEventPostFragment extends Fragment {

    private Event event;
    private EventViewModel eventViewModel;
    private FragmentNewPostBinding fragmentNewEventBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        fragmentNewEventBinding = FragmentNewPostBinding.inflate(inflater, parent, false);
        //set viewmodel
        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        // Defines the xml file for the fragment
        return fragmentNewEventBinding.getRoot();
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
