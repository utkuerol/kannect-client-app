package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.FeedRepository;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;

import java.util.List;

public class PostViewModel extends ViewModel {

    private MutableLiveData<List<Post>> posts;
    private Context context;
    private User currentUser;
    private FeedRepository feedRepository;
    private UserRepository userRepository:

    public PostViewModel(Context context) {
        this.context = context;
        feedRepository = new FeedRepository();
        userRepository = new UserRepository();

        SharedPreferences myPrefs = context.getSharedPreferences("CurrentUser", 0);
        currentUser = userRepository.findUserById(myPrefs.getLong("CurrentUserId", 0));
    }

    public void setPostsToPersonalFeed() {
        this.posts = feedRepository.getPersonalFeed(currentUser);
    }

    public MutableLiveData<List<Post>> getPosts() {
        return posts;
    }

}
