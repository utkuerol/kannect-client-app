package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.ViewModel;

import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;

public class LoginViewModel extends ViewModel {
    private User user;

    private UserRepository userRepository = new UserRepository();


    public void invoke(GoogleSignInAccount account){
        user = userRepository.loginUser(account);
    }

}
