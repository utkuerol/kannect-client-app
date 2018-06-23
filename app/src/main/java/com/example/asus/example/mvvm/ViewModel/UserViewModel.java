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

    private MutableLiveData<User> mCurrentUser;
    private MutableLiveData<List<User>> mUsers;
    private MutableLiveData<User> mChosenUser;
    private UserRepository userRepository;
    private Context context;

    public UserViewModel(MutableLiveData<User> mCurrentUser, MutableLiveData<User> mChosenUser, Context context) {
        this.mCurrentUser = mCurrentUser;
        this.mChosenUser = mChosenUser;
        this.context = context;

    }


    public void onItemClick(View view) {

        //context.startActivity(UserProfileActivity.launchWithDetails(view.getContext(), mUser));
    }
}
