package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentEventsInSubcategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.View.Adapter.EventAdapter;
import com.example.asus.example.mvvm.ViewModel.EventViewModel;

/**
 * Activity class for the view regarding showing subcategories and the events which belong to the parent category.
 */
public class EventsInSubcategoryFragment extends Fragment {

    private EventViewModel eventViewModel;
    private FragmentEventsInSubcategoryBinding fragmentEventsInSubcategoryBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        Subcategory subcategory = (Subcategory) getArguments().getSerializable("subcategory");
        MutableLiveData<Subcategory> c = new MutableLiveData<>();
        c.setValue(subcategory);
        fragmentEventsInSubcategoryBinding = FragmentEventsInSubcategoryBinding.inflate(inflater, parent, false);
        //set viewmodel
        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        /*keine Ahnung welche Query*/
        eventViewModel.setEventsFilteredBySubcategory(c);

        //set adapter
        EventAdapter eventAdapter = new EventAdapter();
        eventAdapter.setEventList(eventViewModel.getEvents().getValue());
        fragmentEventsInSubcategoryBinding.eventsInSubcategoryEventRV.setAdapter(eventAdapter);
        fragmentEventsInSubcategoryBinding.eventsInSubcategoryEventRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        // Defines the xml file for the fragment
        return fragmentEventsInSubcategoryBinding.getRoot();
    }

}
