package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

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


    private MutableLiveData<List<User>> users;
    private UserRepository userRepository;
    private Context context;

    /**
     * Constructor to create a new instance with the given application context.
     *
     * @param context
     */
    public UserViewModel(Context context) {
        this.context = context;
    }

    /**
     * Gets the users.
     *
     * @return observable list of users.
     */
    public MutableLiveData<List<User>> getUsers() {
        return users;
    }

    /**
     * Sets the list of users to search results with the given query.
     * @param query to search for users.
     */
    public void setUsersToSearchResults(String query) {

    }

    /**
     * Sets the list of users to subscriptions of the current user.
     */
    public void setUsersToSubscriptions() {

    }

    /**
     * Sets the list of users to subscribers of the current user.
     */
    public void setUsersToSubscribers() {

    }

}
