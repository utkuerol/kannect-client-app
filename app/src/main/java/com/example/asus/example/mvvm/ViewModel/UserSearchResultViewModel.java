package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.EventRepository;
import com.example.asus.example.mvvm.Model.Repository.GroupRepository;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;

import java.util.List;

public class UserSearchResultViewModel extends ViewModel {

    private MutableLiveData<List<User>> mUsers;

    private UserRepository userRepository;

    public UserSearchResultViewModel(String searchQuery) {

        this.userRepository = new UserRepository();
        mUsers = userRepository.getUser(searchQuery);
    }



}
