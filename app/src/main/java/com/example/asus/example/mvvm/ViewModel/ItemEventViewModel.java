package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.EventRepository;

import java.util.Date;
import java.util.List;

import javax.swing.text.View;

/**
 * ViewModel class for one specific event, and is responsible for preparing and managing the data for Views,
 * which need the information of this particular event, by handling the communication of the View with the
 * EventRepository class, which has the group business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class ItemEventViewModel extends ViewModel {

    private MutableLiveData<Event> event;
    private Context context;
    private EventRepository eventRepository;

    /**
     * creates an instance with the chosen event and application context.
     *
     * @param event   to set
     * @param context of the application
     */
    public ItemEventViewModel(MutableLiveData<Event> event, Context context) {
        this.context = context;
        this.event = event;
    }

    /**
     * Gets the event
     * @return observable event.
     */
    public MutableLiveData<Event> getEvent() {
        return event;
    }

    /**
     * Sets the event
     * @param event to set to.
     */
    public void setEvent(MutableLiveData<Event> event) {
    }

    /**
     * Starts EventFeedActivity with the event.
     * @param view
     */
    public void onItemClick(View view) {

        //context.startActivity(EventFeedActivity.launchWithDetails(view.getContext(), mChosenEvent));
    }

    /**
     * method to get the Name of the Event.
     * @return name of the Event.
     */
    public String getName() {
        return name;
    }


    /**
     * method to get the Date, on which the Event will take place.
     * @return the Date on which the Event will take place.
     */
    public Date getDate() {
        return date;
    }


    /**
     * method to get the description of the Event.
     * @return description of the Event.
     */
    public String getDescription() {
        return description;
    }

    /**
     * method to get the user who created the Event.
     * @return the Creator of the Event.
     */
    public User getCreator() {
        return creator;
    }


    /**
     * method to get the Category this Event belongs to.
     * @return the Category this Events belongs to.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * method to get the Subcategory this Event belongs to.
     * @return the Subcategory this Event belongs to.
     */
    public Subcategory getSubcategory() {
        return subcategory;
    }


    /**
     * method to get the imageUrl of the profile picture of the Event.
     * @return the imageUrl of the profile picture.
     */
    public String getImageUrl() {
        return imageUrl;
    }


    /**
     * method to get the List of User who want to participate in this Event.
     * @return List of Participants
     */
    public List<User> getParticipants() {
        return participants;
    }

    /**
     * Gets the feed of the event.
     * @return list of posts.
     */
    public List<Post> getEventFeed() {
    }

    /**
     * Checks if the current user is the creator of the event
     * @return boolean result
     */
    public boolean isCreator() {
    }

    /**
     * checks if the current user is participating in this event.
     * @return boolean result
     */
    public boolean participatingThisEvent() {
    }


    /**
     * Participates in the event.
     */
    public void participateEvent() {
    }

    /**
     * Leaves the event
     */
    public void leaveEvent() {
    }

    /**
     * Edits the event with the given parameters.
     * @param newName to bet set.
     * @param newDescription to be set.
     */
    public void editEvent(String newName, String newDescription) {
    }

    /**
     * Deletes the event.
     */
    public void deleteEvent() {
    }

    /**
     * Creates a post owned by this event.
     *
     * @param text for the post.
     */
    public void createPost(String text) {
    }


}
