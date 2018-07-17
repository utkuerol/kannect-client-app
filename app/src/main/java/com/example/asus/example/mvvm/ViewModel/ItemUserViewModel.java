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
 * ViewModel class for one specific user, and is responsible for preparing and managing the data for Views,
 * which need the information of this particular user, by handling the communication of the View with the
 * UserRepository class, which has the user business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class ItemUserViewModel extends ViewModel {

    private MutableLiveData<User> chosenUser;
    private Context context;

    /**
     * Creates an instance with the chosen/given user and the application context.
     *
     * @param user    needed to be shown.
     * @param context of the application.
     */
    public ItemUserViewModel(User user, Context context) {
        this.chosenUser = user;
        this.context = context;
    }

    /**
     * Gets the chosen user.
     * @return observable user.
     */
    public MutableLiveData<User> getChosenUser() {
        return chosenUser;
    }

    /**
     * Sets the chosen user.
     * @param user to set.
     */
    public void setChosenUser(MutableLiveData<User> user) {
    }

    /**
     * Starts UserProfileActivity with the chosen user.
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

    /**
     * method to get the list of joined groups.
     * @return list of groups
     */
    public List<Group> getJoinedGroups() {
    }

    /**
     * method to get the list of event, in which the user is participating.
     * @return list of events
     */
    public List<Event> getParticipatedEvents() {
    }

    /**
     * Gets all posts created by the current user.
     * @return
     */
    public List<Post> getUserProfile() {
    }

    /**
     * Gets the personal feed of the current user, which includes the posts owned by
     * the users joined groups, participating events and subscribed users.
     * @return list of posts.
     */
    public List<Post> getPersonalFeed() {
    }

    /**
     * Checks if the current profile is the profile of the current users own profile.
     * @return boolean result
     */
    public boolean isCurrentUsersProfile() {
    }

    /**
     * Subscribes the chosenUser by the current user.
     */
    public void subscribeUser() {
    }

    /**
     * Unsubscribes the chosenUser by the current user.
     */
    public void unsubscribeUser() {
    }

    /**
     * Creates a new post for the current user. This will only be available from the
     * user profile view of the current user.
     * @param text for the post to be created.
     */
    public void createPost(String text) {
    }


}
