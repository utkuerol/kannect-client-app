package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.FeedRepository;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;

import java.util.List;

public class PostViewModel extends ViewModel {

    private MutableLiveData<List<Post>> feed;
    private Context context;

    private FeedRepository feedRepository;

    public PostViewModel(Context context) {
        this.context = context;
    }

    public void setFeedToPersonalFeed() {}
    public void setFeedToGroupFeed(MutableLiveData<Group> group) {}
    public void setFeedToEventFeed(MutableLiveData<Event> event) {}
    public void setFeedToUserProfile(MutableLiveData<User> user) {}




}
