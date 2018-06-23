package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.User;

import javax.swing.text.View;

public class EventViewModel extends ViewModel {

    private MutableLiveData<User> mCurrentUser;
    private MutableLiveData<Event> mChosenEvent;
    private Context context;

    public EventViewModel(MutableLiveData<User> mCurrentUser, MutableLiveData<Event> mChosenEvent, Context context) {
        this.mCurrentUser = mCurrentUser;
        this.mChosenEvent = mChosenEvent;
        this.context = context;
    }


    public void onItemClick(View view) {

        //context.startActivity(EventFeedActivity.launchWithDetails(view.getContext(), mChosenEvent));
    }
}
