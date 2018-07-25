package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.databinding.FragmentEventsInSubcategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.EventAdapter;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerEvent;
import com.example.asus.example.mvvm.ViewModel.EventViewModel;

/**
 * Activity class for the view regarding showing subcategories and the events which belong to the parent category.
 */
public class EventsInSubcategoryFragment extends Fragment {

    private Subcategory subcategory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        //set viewmodel
        final EventViewModel eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        eventViewModel.init(getContext());


        //set adapter
        final EventAdapter eventAdapter = new EventAdapter();
        OnItemClickListenerEvent listener = new OnItemClickListenerEvent() {
            @Override
            public void onItemClick(Event item) {
                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchEventFeedFragment(item);
            }
        };
        eventAdapter.setListener(listener);

        //Set binding
        final FragmentEventsInSubcategoryBinding fragmentEventsInSubcategoryBinding
                = FragmentEventsInSubcategoryBinding.inflate(inflater, parent, false);
        fragmentEventsInSubcategoryBinding.eventsInSubcategoryEventRV.setAdapter(eventAdapter);


        eventViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    eventViewModel.setEventsFilteredBySubcategory(subcategory);
                    eventAdapter.setEventList(eventViewModel.getEvents().getValue());

                }
            }
        });

        fragmentEventsInSubcategoryBinding.eventsInSubcategoryEventRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return fragmentEventsInSubcategoryBinding.getRoot();
    }


    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
}
