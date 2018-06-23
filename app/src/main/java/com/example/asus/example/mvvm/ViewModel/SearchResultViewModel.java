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

public class SearchResultViewModel extends ViewModel{

    private MutableLiveData<List<User>> mUsers;
    private MutableLiveData<List<Event>> mEvents;
    private MutableLiveData<List<Group>> mGroups;
    private EventRepository eventRepository;
    private GroupRepository groupRepository;
    private UserRepository userRepository;

    public SearchResultViewModel() {
        this.eventRepository = new EventRepository();
        this.groupRepository = new GroupRepository();
        this.userRepository = new UserRepository();
    }

    public void getEvents(String searchQuery) {
        mEvents = eventRepository.getEvents(searchQuery);
    }

    public void getGroups(String searchQuery) {
        mGroups = groupRepository.getGroups(searchQuery);
    }

    public void getUsers(String searchQuery) {
        mUsers = userRepository.getUser(searchQuery);
    }

}
