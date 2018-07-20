package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/**
 * ViewModel class for login, that is responsible for preparing and managing the data for Views
 * regarding login functions, by handling the communication of the View with the
 * UserRepository class, which has the user/account business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class LoginViewModel extends ViewModel {

    private MutableLiveData<User> user;
    private UserRepository userRepository = new UserRepository();

    /**
     * Invokes the chains of events, leading to user login.
     *
     * @param account google sign in account.
     */
    public void invoke(GoogleSignInAccount account){
        user = userRepository.loginUser(account);
    }

    /**
     * Gets the user, which is logging in.
     *
     * @return observable user.
     */
    public MutableLiveData<User> getUser() {
        return user;
    }
}
