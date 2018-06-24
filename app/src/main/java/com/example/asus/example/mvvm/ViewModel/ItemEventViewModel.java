package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;

import java.util.Date;
import java.util.List;

import javax.swing.text.View;

/**
 * ViewModel class for itemEvents, that is responsible for preparing and managing the data for Views,
 * which need a list of itemEvents, by handling the communication of the View with the
 * Recyclerview element.
 */
public class ItemEventViewModel extends ViewModel {

    private MutableLiveData<Event> event;
    private Context context;

    /**
     * Creates an instance with the given application context.
     *
     * @param context of the application.
     */
    public ItemEventViewModel(Event event, Context context) {
        this.context = context;
        MutableLiveData<Event> ev = new MutableLiveData<Event>();
        this.event = ev;
    }

    public Event getEvent() {
        return event.getValue();
    }

    public void setEvent(Event event) {
        MutableLiveData<Event> e = new MutableLiveData<Event>();
        e.setValue(event);
        this.event = e;
    }

    /**
     * method will be invoked by clicking on the item
     *
     * @param view the current View
     */
    public void onItemClick(View view) {

        //context.startActivity(EventFeedActivity.launchWithDetails(view.getContext(), mChosenEvent));
    }


    public String getName() {
    }

    public Date getDate() {
    }

    public String getDateAsString() {
    }

    public String getDescription() {
    }

    public User getCreator() {
    }

    public String getCreatorName() {
    }

    public Category getCategory() {
    }

    public Subcategory getSubcategory() {
    }

    public String getImageUrl() {
    }

    public List<User> getParticipants() {
    }

    public List<Post> getEventFeed() {
    }

    public boolean isCreator() {
    }

    public boolean participatingThisEvent() {
    }


    public void participateEvent(User user, Event event) {
    }


    public void leaveEvent(User user, Event event) {
    }

    public void editEvent(String newName, String newDescription) {
    }

    public void deleteEvent() {
    }

    public void createPost(Post post) {
    }


}
