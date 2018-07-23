package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentNewEventBinding;
import com.example.asus.example.databinding.FragmentNewGroupBinding;
import com.example.asus.example.mvvm.ViewModel.EventViewModel;
import com.example.asus.example.mvvm.ViewModel.GroupViewModel;
import com.example.asus.example.mvvm.ViewModel.ItemEventViewModel;

public class NewEventPostFragment extends Fragment {

    private EventViewModel eventViewModel;
    private FragmentNewEventBinding fragmentNewEventBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        fragmentNewEventBinding = FragmentNewEventBinding.inflate(inflater, parent, false);
        //set viewmodel
        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        // Defines the xml file for the fragment
        return fragmentNewEventBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);


        /*keine Ahnung welche Query*/
        //eventViewModel.add(null);


        //TODO: observe livedata somehow

    }
}
