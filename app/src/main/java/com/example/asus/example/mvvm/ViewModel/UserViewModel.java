package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;

import com.example.asus.example.mvvm.Model.Entities.User;

import java.util.List;

import javax.swing.text.View;

public class UserViewModel extends ViewModel {

    private MutableLiveData<User> mUser;
    private Context context;

    public UserViewModel(MutableLiveData<User> mUser, Context context) {
        this.mUser = mUser;
        this.context = context;
    }

    /**
     * Starts new activity with the context in User Profile Activity, passing the mUser information
     * @param view
     */
    public void onItemClick(View view) {
        
        //context.startActivity(UserProfileActivity.launchDetail(view.getContext(), mUser));
    }
}
