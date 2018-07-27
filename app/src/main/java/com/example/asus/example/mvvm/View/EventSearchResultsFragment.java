package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentEventSearchResultBinding;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.EventAdapter;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerEvent;
import com.example.asus.example.mvvm.ViewModel.EventViewModel;

import java.util.List;

/**
 * This fragment displays events related to the searched terms.
 */
public class EventSearchResultsFragment extends Fragment {

    private String query;

    private EventViewModel eventViewModel;
    private FragmentEventSearchResultBinding fragmentEventSearchResultBinding;

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        fragmentEventSearchResultBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_event_search_result, parent, false);
        //set viewmodel
        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        eventViewModel.init(getContext().getApplicationContext());

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


        fragmentEventSearchResultBinding.eventSearchResultEventRV.setAdapter(eventAdapter);


        final Observer<List<Event>> eventsObserver = new Observer<List<Event>>() {
            @Override
            public void onChanged(@Nullable List<Event> events) {
                if (events != null) {
                    eventAdapter.setEventList(events);
                    fragmentEventSearchResultBinding.eventSearchResultEventRV.setAdapter(eventAdapter);

                }
            }
        };

        eventViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    eventViewModel.setEventsToSearchResults(query);
                    eventViewModel.getEvents().observe(EventSearchResultsFragment.this, eventsObserver);
                }
            }
        });

        fragmentEventSearchResultBinding.eventSearchResultEventRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return fragmentEventSearchResultBinding.getRoot();
    }
}
