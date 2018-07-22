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
import com.example.asus.example.mvvm.View.Adapter.EventAdapter;
import com.example.asus.example.mvvm.ViewModel.EventViewModel;
import com.example.asus.example.databinding.FragmentEventSearchResultBinding;

/**
 * This fragment displays events related to the searched terms.
 */
public class EventSearchResultsFragment extends Fragment {


    private EventViewModel eventViewModel;
    private FragmentEventSearchResultBinding fragmentEventSearchResultBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_event_search_result, parent, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        //set viewmodel
        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        /*keine Ahnung welche Query*/
        eventViewModel.setEventsToSearchResults(null);

        //set adapter
        EventAdapter eventAdapter = new EventAdapter();
        eventAdapter.setEventList(eventViewModel.getEvents().getValue());
        fragmentEventSearchResultBinding.eventSearchResultRV.setAdapter(eventAdapter);
        fragmentEventSearchResultBinding.eventSearchResultRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //TODO: observe livedata somehow

    }

}
