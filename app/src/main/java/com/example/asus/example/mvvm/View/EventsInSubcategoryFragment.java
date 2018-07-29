package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asus.example.R;
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
public class EventsInSubcategoryFragment extends Fragment implements View.OnClickListener {

    private Subcategory subcategory;
    FragmentEventsInSubcategoryBinding fragmentEventsInSubcategoryBinding;

    /**
     * Method which will be called when this fragment is created.
     * Inflates the View, sets the ViewModel and the Adapter with the right onClickListener for the
     * RecyclerView.
     * Observes getCurrentUser to check if there is a value or a null object.
     * @param inflater           inflates the layout on the screen
     * @param parent             of this ViewGroup
     * @param savedInstanceState state of the Application as a Bundle
     * @return the outermost View in the layout file associated with the Binding.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        //Set binding
        fragmentEventsInSubcategoryBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_events_in_subcategory, parent, false);

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


        fragmentEventsInSubcategoryBinding.eventsInSubcategoryEventRV.setAdapter(eventAdapter);


        eventViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    eventViewModel.setEventsFilteredBySubcategory(subcategory);
                    eventAdapter.setEventList(eventViewModel.getEvents().getValue());
                    fragmentEventsInSubcategoryBinding.eventsInSubcategoryEventRV.setAdapter(eventAdapter);


                } else {
                    Toast.makeText(getContext(), "Server Error", Toast.LENGTH_SHORT);
                }
            }
        });


        ImageView eventsInSubcategoryCreateEventIV = (ImageView) fragmentEventsInSubcategoryBinding.eventsInSubcategoryCreateEventIV;
        eventsInSubcategoryCreateEventIV.setOnClickListener(this);


        fragmentEventsInSubcategoryBinding.eventsInSubcategoryEventRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return fragmentEventsInSubcategoryBinding.getRoot();
    }

    /**
     * Method which handles the click on the createNewEvent icon in the view.
     * Directs the User to the View for creating a new Event.
     * @param v the view which the user clicked on.
     */
    @Override
    public void onClick(View v) {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
        switch (v.getId()) {
            case R.id.eventsInSubcategoryCreateEventIV:

                navigation_drawer_activity.launchNewEventInSubcategory(subcategory);
                break;
        }
    }


    /**
     * sets the subcategory of which all events will be shown.
     * @param subcategory which the user clicked on.
     */
    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
}
