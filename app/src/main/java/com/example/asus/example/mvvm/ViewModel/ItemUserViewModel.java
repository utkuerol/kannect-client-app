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

public class ItemUserViewModel extends ViewModel {

    private MutableLiveData<User> chosenUser;
    private Context context;

    public ItemUserViewModel(MutableLiveData<User> user, Context context) {
        this.chosenUser = user;
        this.context = context;
    }

    public MutableLiveData<User> getChosenUser() {
        return chosenUser;
    }

    public void setChosenUser(MutableLiveData<User> user) {}

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
