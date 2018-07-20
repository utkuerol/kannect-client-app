package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.FeedRepository;

import java.util.List;

public class PostViewModel extends ViewModel {

    private MutableLiveData<List<Post>> posts;
    private Context context;
    private User currentUser;
    private FeedRepository feedRepository;

    public PostViewModel(Context context) {
        this.context = context;
    }

    public void setPostsToPersonalFeed() {
        this.posts = feedRepository.getPersonalFeed(currentUser);
    }

    public void setPostsToGroupFeed(Group group) {
        this.posts = feedRepository.getGroupFeed(group);
    }

    public void setPostsToEventFeed(Event event) {
        this.posts = feedRepository.getEventFeed(event);
    }

    public LiveData<List<Post>> getPosts() {
        return posts;
    }

}
