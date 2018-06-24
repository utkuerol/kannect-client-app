package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;

import java.util.List;

import javax.swing.text.View;

/**
 * ViewModel class for itemUser, that is responsible for preparing and managing the data for Views,
 * which need a list of itemUser, by handling the communication of the View with the
 * Recyclerview element.
 */
public class ItemUserViewModel extends ViewModel {

    private MutableLiveData<User> chosenUser;
    private Context context;

    /**
     * Creates an instance with the given application context.
     *
     * @param context of the application.
     */
    public ItemUserViewModel(User user, Context context) {
        MutableLiveData<User> p = new MutableLiveData<User>();
        p.setValue(user);
        this.chosenUser = p;
        this.context = context;
    }

    public User getChosenUser() {
        return chosenUser.getValue();
    }

    public void setChosenUser(User user) {
    }

    /**
     * method will be invoked by clicking on the user item
     *
     * @param view
     */
    public void onItemClick(View view) {

        //context.startActivity(UserProfileActivity.launchWithDetails(view.getContext(), mUser));
    }


    /**
     * method to get the name of the User
     * @return the name of the User
     */
    public String getName() {

    }


    /**
     * method to get the Email of the User.
     * @return the Email of the User.
     */
    public String getEmail() {

    }


    /**
     * method to get the imageURl of the Users profile picture
     * @return the imageUrl
     */
    public String getImageUrl() {

    }


    /**
     * method to get the a List of the Users, this User subscribes to
     * @return List of Subscriptions
     */
    public List<User> getSubscriptions() {

    }


    /**
     * method to get the List of Users, who subscribe to this User
     * @return List of Subscribers
     */
    public List<User> getSubscribers() {

    }

    public List<Group> getJoinedGroups() {
    }

    public List<Event> getParticipatedEvents() {
    }

    public List<Post> getUserProfile() {
    }

    public List<Post> getPersonalFeed() {
    }

    public boolean isCurrentUsersProfile() {
    }

    public void subscribeUser() {
    }

    public void unsubscribeUser() {
    }

    public void createPost(String text) {
    }


}
