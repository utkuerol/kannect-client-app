package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;

import java.util.List;

import javax.swing.text.View;

public class UserViewModel extends ViewModel {

    private MutableLiveData<List<User>> users;
    private UserRepository userRepository;
    private Context context;

    public UserViewModel(Context context) {
        this.context = context;
    }

    public void setUsersToSearchResults(String query) {

    }
    public void setUsersToSubscriptions() {

    }
    public void setUsersToSubscribers() {

    }

}
