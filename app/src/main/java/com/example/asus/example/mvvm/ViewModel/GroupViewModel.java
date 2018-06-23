package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.User;

import javax.swing.text.View;

public class GroupViewModel extends ViewModel {

    private MutableLiveData<User> mCurrentUser;
    private MutableLiveData<Group> mChosenGroup;
    private Context context;

    public GroupViewModel(MutableLiveData<User> mCurrentUser, MutableLiveData<Group> mChosenGroup, Context context) {
        this.mCurrentUser = mCurrentUser;
        this.mChosenGroup = mChosenGroup;
        this.context = context;
    }


    public void onItemClick(View view) {

        //context.startActivity(GroupFeedActivity.launchWithDetails(view.getContext(), mChosenEvent));
    }
}
