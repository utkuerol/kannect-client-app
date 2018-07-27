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

    private MutableLiveData<User> user = new MutableLiveData<>();
    private UserRepository userRepository = new UserRepository();


    /**
     * Invokes the chains of events, leading to user login.
     *
     * @param account google sign in account.
     */
    public MutableLiveData<User> invoke(GoogleSignInAccount account) {
        return userRepository.findByEmail(account.getEmail());
    }

    /**
     * creates and sets the currently logged in user with the help of a
     * GoogleSignIgnAccount.
     *
     * @param account with which the user object will be created.
     */
    public void createAndSetCurrentUser(GoogleSignInAccount account) {
        User u = new User();
        u.setEmail(account.getEmail());
        u.setImageUrl(account.getPhotoUrl() != null ? account.getPhotoUrl().toString() : null);
        u.setName(account.getDisplayName());

        userRepository.createUser(u);
        getUser().setValue(u);
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
