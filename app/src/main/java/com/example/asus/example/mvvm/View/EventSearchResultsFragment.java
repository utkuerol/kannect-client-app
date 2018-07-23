package com.example.asus.example.mvvm.View;

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
import com.example.asus.example.databinding.FragmentEventSearchResultBinding;
import com.example.asus.example.mvvm.View.Adapter.EventAdapter;
import com.example.asus.example.mvvm.ViewModel.EventViewModel;

/**
 * This fragment displays events related to the searched terms.
 */
public class EventSearchResultsFragment extends Fragment {


    private EventViewModel eventViewModel;
    private FragmentEventSearchResultBinding fragmentEventSearchResultBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        //get extra arguments from the initiating activity
        String query = getArguments().getString("query");
        fragmentEventSearchResultBinding = FragmentEventSearchResultBinding.inflate(inflater, parent, false);

        //set viewmodel
        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        /*keine Ahnung welche Query*/
        eventViewModel.setEventsToSearchResults(query);

        //set adapter
        EventAdapter eventAdapter = new EventAdapter();
        eventAdapter.setEventList(eventViewModel.getEvents().getValue());
        fragmentEventSearchResultBinding.eventSearchResultEventRV.setAdapter(eventAdapter);
        fragmentEventSearchResultBinding.eventSearchResultEventRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
        // Defines the xml file for the fragment
        return fragmentEventSearchResultBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);


        //TODO: observe livedata somehow

    }

}
