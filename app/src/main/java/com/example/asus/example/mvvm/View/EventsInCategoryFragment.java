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
import com.example.asus.example.databinding.FragmentEventsInCategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.View.Adapter.EventAdapter;
import com.example.asus.example.mvvm.ViewModel.EventViewModel;

import java.net.MalformedURLException;

/**
 * Fragment for the view, to show all events that exist in the chosen Category.
 */
public class EventsInCategoryFragment extends Fragment {

    private EventViewModel eventViewModel;
    private FragmentEventsInCategoryBinding fragmentEventsInCategoryBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        //get extra arguments from the initiating activity
        Category category = (Category) getArguments().getSerializable("category");
        MutableLiveData<Category> c = new MutableLiveData<>();
        c.setValue(category);

        fragmentEventsInCategoryBinding = FragmentEventsInCategoryBinding.inflate(inflater, parent, false);
        //set viewmodel
        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        /*keine Ahnung welche Query*/
        eventViewModel.setEventsFilteredByCategory(c);

        //set adapter
        EventAdapter eventAdapter = new EventAdapter();
        eventAdapter.setEventList(eventViewModel.getEvents().getValue());
        fragmentEventsInCategoryBinding.eventsInCategoryEventRV.setAdapter(eventAdapter);
        fragmentEventsInCategoryBinding.eventsInCategoryEventRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
        // Defines the xml file for the fragment

        return fragmentEventsInCategoryBinding.getRoot();
    }

    public void launchFragment() {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
        navigation_drawer_activity.launchEventInCategoryFragment();
    }
}
