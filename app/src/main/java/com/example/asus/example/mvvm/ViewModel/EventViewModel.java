package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;

import java.util.List;

import javax.swing.text.View;

/**
 * ViewModel class for categories, that is responsible for preparing and managing the data for Views,
 * which need a list of categories, by handling the communication of the View with the
 * CategoryRepository class, which has the category business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class EventViewModel extends ViewModel {

    private MutableLiveData<List<Event>> events;
    private Context context;

    /**
     * Creates an instance with the given application context.
     *
     * @param context of the application.
     */
    public EventViewModel(Context context) {
        this.context = context;
    }

    public void setEventsToSearchResults(String query) {
    }

    public void setEventsFilteredByCategory(Category category) {
    }

    public void setEventsFilteredBySubcategory(Subcategory subcategory) {
    }

    public void setEventsToParticipatingEvents() {
    }


    /**
     * method which will be invoked
     *
     * @param view the activity view
     */
    public void onItemClick(View view) {

        //context.startActivity(EventFeedActivity.launchWithDetails(view.getContext(), mChosenEvent));
    }

    public List<Event> getEvents() {
        return events.getValue();
    }


}
