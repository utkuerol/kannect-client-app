package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;

import java.util.List;

/**
 * ViewModel class for Users that is responsible for preparing and managing the data for Views,
 * which need a list of users, by handling the communication of the View with the
 * UserRepository class, which has the user business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class UserViewModel extends ViewModel {


    private MutableLiveData<List<User>> users = new MutableLiveData<>();
    private MutableLiveData<User> currentUser;
    private UserRepository userRepository;


    public void init(Context context) {
        users = new MutableLiveData<>();
        userRepository = new UserRepository();

        SharedPreferences myPrefs = context.getSharedPreferences("CurrentUser", 0);
        currentUser = userRepository.getUserByID(myPrefs.getInt("CurrentUserId", 0));
    }

    /**
     * Gets the users.
     *
     * @return observable list of users.
     */
    public MutableLiveData<List<User>> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users.setValue(users);
    }

    /**
     * Sets the list of users to search results with the given query.
     * @param query to search for users.
     */
    public void setUsersToSearchResults(String query) {
        users = userRepository.getUsers(query);
    }

    /**
     * Sets the list of users to subscriptions of the current user.
     */
    public void setUsersToSubscriptions() {
        users.setValue(currentUser.getValue().getSubscriptions());
    }

    /**
     * Sets the list of users to subscribers of the current user.
     */
    public void setUsersToSubscribers() {
        users.setValue(currentUser.getValue().getSubscribers());
    }

    public MutableLiveData<User> getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(MutableLiveData<User> currentUser) {
        this.currentUser = currentUser;
    }
}
