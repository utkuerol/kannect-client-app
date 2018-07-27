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
import android.widget.Toast;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentEventsInCategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.EventAdapter;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerEvent;
import com.example.asus.example.mvvm.ViewModel.EventViewModel;

/**
 * Fragment for the view, to show all events that exist in the chosen Category.
 */
public class EventsInCategoryFragment extends Fragment {

    private Category category;
    private EventViewModel eventViewModel;
    private FragmentEventsInCategoryBinding fragmentEventsInCategoryBinding;


    /**
     * Method which will be called when this fragment is created.
     * Inflates the View, sets the ViewModel and the Adapter with the right onClickListener for the
     * RecyclerView.
     *
     * @param inflater           inflates the layout on the screen
     * @param parent             of this ViewGroup
     * @param savedInstanceState state of the Application as a Bundle
     * @return the outermost View in the layout file associated with the Binding.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        fragmentEventsInCategoryBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_events_in_category, parent, false);

        //set viewmodel
        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
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


        fragmentEventsInCategoryBinding.eventsInCategoryEventRV.setAdapter(eventAdapter);

        eventViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    eventViewModel.setEventsFilteredByCategory(category);
                    eventAdapter.setEventList(eventViewModel.getEvents().getValue());
                    fragmentEventsInCategoryBinding.eventsInCategoryEventRV.setAdapter(eventAdapter);
                } else {
                    Toast.makeText(getContext(), "Server Error", Toast.LENGTH_SHORT);
                }


            }
        });

        fragmentEventsInCategoryBinding.eventsInCategoryEventRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return fragmentEventsInCategoryBinding.getRoot();
    }


    /**
     * sets the category of which all events will be shown.
     * @param category which was selected by the user.
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}
