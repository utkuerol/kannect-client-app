package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.EventRepository;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;

import java.util.List;

/**
 * ViewModel class for events, that is responsible for preparing and managing the data for Views,
 * which need a list of events, by handling the communication of the View with the
 * EventRepository class, which has the group business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class EventViewModel extends ViewModel {

    private MutableLiveData<List<Event>> events;
    private MutableLiveData<User> currentUser;
    private EventRepository eventRepository;


    public void init(Context context) {
        eventRepository = new EventRepository();

        UserRepository userRepository = new UserRepository();
        SharedPreferences myPrefs = context.getSharedPreferences("CurrentUser", 0);
        currentUser = userRepository.getUserByID(myPrefs.getInt("CurrentUserId", 0));
    }

    /**
     * Sets the events to search results of the given query.
     * @param query to search.
     */
    public void setEventsToSearchResults(String query) {
        events = eventRepository.getEvents(query);
    }

    /**
     * Sets the events with all groups of the given category.
     * @param category to filter
     */
    public void setEventsFilteredByCategory(MutableLiveData<Category> category) {
        events.setValue(category.getValue().getEvents());
    }

    /**
     * Sets the events with all groups of the given subcategory.
     * @param subcategory to filter.
     */
    public void setEventsFilteredBySubcategory(MutableLiveData<Subcategory> subcategory) {
        events.setValue(subcategory.getValue().getEvents());
    }

    /**
     * Sets the events to current user's list of participating events.
     */
    public void setEventsToParticipatingEvents() {
        events.setValue(currentUser.getValue().getParticipatedEvents());
    }


    /**
     * Gets the list of groups.
     * @return observable list of groups.
     */
    public MutableLiveData<List<Event>> getEvents() {
        return events;
    }


    public MutableLiveData<User> getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(MutableLiveData<User> currentUser) {
        this.currentUser = currentUser;
    }
}
