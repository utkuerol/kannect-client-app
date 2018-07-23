package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.PostRepository;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;


/**
 * ViewModel class for one specific user, and is responsible for preparing and managing the data for Views,
 * which need the information of this particular user, by handling the communication of the View with the
 * UserRepository class, which has the user business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class ItemUserViewModel extends ViewModel {

    private MutableLiveData<User> chosenUser;
    private User currentUser;
    private Context context;
    private UserRepository userRepository;
    private PostRepository postRepository;

    /**
     * Creates an instance with the chosen/given user and the application context.
     *
     * @param user    needed to be shown.
     * @param context of the application.
     */
    public ItemUserViewModel(MutableLiveData<User> user, Context context) {
        this.chosenUser = user;
        this.context = context;
        userRepository = new UserRepository();
        postRepository = new PostRepository();


        SharedPreferences myPrefs = context.getSharedPreferences("CurrentUser", 0);
        currentUser = userRepository.getUserByID(myPrefs.getLong("CurrentUserId", 0)).getValue();
    }

    /**
     * Gets the chosen user.
     * @return observable user.
     */
    public MutableLiveData<User> getChosenUser() {
        return chosenUser;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get().load(imageUrl)
                // .placeholder(R.drawable.placeholder)
                .into(view);
    }

    /**
     * Starts UserProfileFragment with the chosen user.
     * @param view
     */
    public void onItemClick(View view) {

        //context.startActivity(UserProfileFragment.launchWithDetails(view.getContext(), mUser));
    }

    /**
     * Sets the chosen user.
     *
     * @param user to set.
     */
    public void setChosenUser(User user) {
        this.chosenUser.setValue(user);
    }

    /**
     * method to get the name of the User
     * @return the name of the User
     */
    public String getName() {
        return chosenUser.getValue().getName();
    }

    /**
     * method to get the Email of the User.
     * @return the Email of the User.
     */
    public String getEmail() {
        return chosenUser.getValue().getEmail();
    }

    /**
     * method to get the imageURl of the Users profile picture
     * @return the imageUrl
     */
    public String getImageUrl() {
        return chosenUser.getValue().getImageUrl();
    }

    /**
     * method to get the a List of the Users, this User subscribes to
     * @return List of Subscriptions
     */
    public List<User> getSubscriptions() {
        return this.chosenUser.getValue().getSubscriptions();
    }

    /**
     * method to get the number of users who subscribe to the chosen user
     *
     * @return size of the list of subscribers
     */
    public int getNumberOfSubscribers() {
        return chosenUser.getValue().getSubscribers().size();
    }

    /**
     * method to get the number of users who the chosen user is subscribed to
     *
     * @return size of list of subscriptions of the user
     */
    public int getNumberOfSubscriptions() {
        return chosenUser.getValue().getSubscriptions().size();
    }
    /**
     * method to get the List of Users, who subscribe to this User
     * @return List of Subscribers
     */
    public List<User> getSubscribers() {
        return this.chosenUser.getValue().getSubscribers();
    }

    /**
     * method to get the list of joined groups.
     * @return list of groups
     */
    public List<Group> getJoinedGroups() {
        return this.chosenUser.getValue().getJoinedGroups();

    }

    /**
     * method to get the list of event, in which the user is participating.
     * @return list of events
     */
    public List<Event> getParticipatedEvents() {
        return this.chosenUser.getValue().getParticipatedEvents();
    }

    /**
     * Gets all posts created by the current user.
     * @return
     */
    public List<Post> getUserProfile() {
        return userRepository.getUserProfile(currentUser).getValue();
    }


    /**
     * Checks if the current profile is the profile of the current users own profile.
     * @return boolean result
     */
    public boolean isCurrentUsersProfile() {
        return chosenUser.getValue().getId() == currentUser.getId();
    }

    /**
     * Subscribes the chosenUser by the current user.
     */
    public void subscribeUser() {
        userRepository.subscribeUser(currentUser, chosenUser.getValue());
    }

    /**
     * Unsubscribes the chosenUser by the current user.
     */
    public void unsubscribeUser() {
        userRepository.unsubscribeUser(currentUser, chosenUser.getValue());
    }

    /**
     * Creates a new post for the current user. This will only be available from the
     * user profile view of the current user.
     * @param text for the post to be created.
     */
    public void createPost(String text) {
        Post postToCreate = new Post();
        postToCreate.setText(text);
        postToCreate.setCreator(currentUser);
        postToCreate.setDate(new Date());
        postToCreate.setOwnerUser(currentUser);
        postToCreate.setOwnedBy(currentUser.getId());
        postRepository.createPost(postToCreate);
    }


}

