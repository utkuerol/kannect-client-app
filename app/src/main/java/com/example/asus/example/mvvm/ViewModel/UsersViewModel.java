package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.EventRepository;
import com.example.asus.example.mvvm.Model.Repository.GroupRepository;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;

import java.util.List;

public class UsersViewModel extends ViewModel {

    private MutableLiveData<User> currentUser;
    private MutableLiveData<List<User>> mUsers;
    private UserRepository userRepository;
    private Context context;

    public UsersViewModel(Context context, MutableLiveData<User> currentUser) {
        this.currentUser = currentUser;
        this.context = context;
    }

    public void setUsersSearchResults(String query) {

    }

    public void setUsersSubscriptions() {

    }

    public void setUsersSubscribers() {

    }





}
