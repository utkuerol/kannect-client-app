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

    private MutableLiveData<List<Event>> events = new MutableLiveData<>();
    private MutableLiveData<User> currentUser;
    private EventRepository eventRepository;


    /**
     * initializes the Event Repository variable and retrieves the
     * currentUser from storage via SharedPreferences and the given context.
     *
     * @param context of the Application.
     */
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
     * @param category to filter.
     */
    public void setEventsFilteredByCategory(Category category) {
        events.setValue(category.getEvents());
    }

    /**
     * Sets the events with all groups of the given subcategory.
     * @param subcategory to filter.
     */
    public void setEventsFilteredBySubcategory(Subcategory subcategory) {
        events.setValue(subcategory.getEvents());
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


    /**
     * method to get the currently logged in user.
     * @return logged in User as a MutableLiveData object.
     */
    public MutableLiveData<User> getCurrentUser() {
        return currentUser;
    }

    /**
     * sets the currently logged in user.
     * @param currentUser which will be set.
     */
    public void setCurrentUser(MutableLiveData<User> currentUser) {
        this.currentUser = currentUser;
    }
}
