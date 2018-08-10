package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;

/**
 * ViewModel class for login, that is responsible for preparing and managing the data for Views
 * regarding login functions, by handling the communication of the View with the
 * UserRepository class, which has the user/account business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class LoginViewModel extends ViewModel {

    private MutableLiveData<User> user = new MutableLiveData<>();
    private UserRepository userRepository = new UserRepository();


    /**
     * Invokes the chains of events, leading to user login.
     *
     * @param user google sign in account.
     */
    public MutableLiveData<User> invoke(User user) {
        return userRepository.findByEmail(user.getEmail());
    }

    /**
     * creates and sets the currently logged in user with the help of a
     * GoogleSignIgnAccount.
     *
     * @param user with which the user object will be created.
     */
    public MutableLiveData<Boolean> createUser(User user) {

        return userRepository.createUser(user);
    }


    /**
     * Gets the user, which is logging in.
     *
     * @return observable user.
     */
    public MutableLiveData<User> getUser() {
        return user;
    }

    /**
     * sets the logged in user.
     * @param user which will be set.
     */
    public void setUser(MutableLiveData<User> user) {
        this.user = user;
    }
}
