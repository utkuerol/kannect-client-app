package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.User;

import java.util.List;

public class SearchResultViewModel extends ViewModel{

    private MutableLiveData<List<User>> mUSers;
    private MutableLiveData<List<Event>> mEvents;
    private MutableLiveData<List<Group>> mGroups;


}
