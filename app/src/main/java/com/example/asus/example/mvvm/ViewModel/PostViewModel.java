package com.example.asus.example.mvvm.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.FeedRepository;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;

import java.util.List;

public class PostViewModel extends AndroidViewModel {

    private MutableLiveData<List<Post>> posts;
    private User currentUser;
    private FeedRepository feedRepository;

    public PostViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        feedRepository = new FeedRepository();
        UserRepository userRepository = new UserRepository();
        SharedPreferences myPrefs = getApplication().getSharedPreferences("CurrentUser", 0);
        currentUser = userRepository.getUserByID(myPrefs.getLong("CurrentUserId", 0)).getValue();
    }

    public void setPostsToPersonalFeed() {
        this.posts = feedRepository.getPersonalFeed(currentUser);
    }

    public MutableLiveData<List<Post>> getPosts() {
        return posts;
    }

}
