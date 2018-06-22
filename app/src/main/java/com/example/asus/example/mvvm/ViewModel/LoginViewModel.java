package com.example.asus.example.mvvm.ViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;


import com.example.asus.example.mvvm.Model.User;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<User> user;

    /**
     * Constructor
     */
    public LoginViewModel(){
        this.user = new MutableLiveData();
        this.user.setValue(new User());
    }


    public LiveData<User> getUser() {
        return user;
    }


    /**
     *With this method the user will be directed to the home page of the App
     * or he will get an error message when the email or the password is not correct.
     */
    public void onLoginClicked(View view){

    }

}
