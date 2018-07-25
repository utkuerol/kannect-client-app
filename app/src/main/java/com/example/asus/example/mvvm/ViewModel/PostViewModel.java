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

    private MutableLiveData<List<Post>> posts = new MutableLiveData<>();
    private MutableLiveData<User> currentUser = new MutableLiveData<>();
    private FeedRepository feedRepository;

    public PostViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        feedRepository = new FeedRepository();
        UserRepository userRepository = new UserRepository();
        SharedPreferences myPrefs = getApplication().getSharedPreferences("CurrentUser", 0);
        currentUser = userRepository.getUserByID(myPrefs.getInt("CurrentUserId", 0));
    }

    public void setPostsToPersonalFeed() {
        this.posts = feedRepository.getPersonalFeed(currentUser.getValue());
    }

    public MutableLiveData<List<Post>> getPosts() {
        return posts;
    }

    public MutableLiveData<User> getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(MutableLiveData<User> currentUser) {
        this.currentUser = currentUser;
    }
}
