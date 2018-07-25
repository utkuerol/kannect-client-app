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
import com.example.asus.example.mvvm.Interfaces.OnItemClickListenerEvent;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.View.Adapter.EventAdapter;
import com.example.asus.example.mvvm.ViewModel.EventViewModel;

/**
 * Activity class for the view regarding showing subcategories and the events which belong to the parent category.
 */
public class EventsInSubcategoryFragment extends Fragment {
    private Subcategory subcategory;
    private EventViewModel eventViewModel;
    private FragmentEventsInSubcategoryBinding fragmentEventsInSubcategoryBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        MutableLiveData<Subcategory> n = new MutableLiveData<>();
        n.setValue(subcategory);
        //set viewmodel
        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        eventViewModel.init();
        eventViewModel.setEventsFilteredBySubcategory(n);

        //set adapter
        EventAdapter eventAdapter = new EventAdapter();
        OnItemClickListenerEvent listener = new OnItemClickListenerEvent() {
            @Override
            public void onItemClick(Event item) {
                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchEventFeedFragment(item);
            }
        };
        eventAdapter.setListener(listener);
        eventAdapter.setEventList(eventViewModel.getEvents().getValue());
        fragmentEventsInSubcategoryBinding.eventsInSubcategoryEventRV.setAdapter(eventAdapter);
        fragmentEventsInSubcategoryBinding.eventsInSubcategoryEventRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_events_in_subcategory, parent, false);
    }


    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
}
