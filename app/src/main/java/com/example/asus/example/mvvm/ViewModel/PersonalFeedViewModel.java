package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.FeedRepository;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;

import java.util.List;

public class PersonalFeedViewModel extends ViewModel {

    private MutableLiveData<List<Post>> mFeed;
    private MutableLiveData<User> mUser;

    private FeedRepository feedRepository;

    public PersonalFeedViewModel(MutableLiveData<User> user) {

        this.feedRepository = new FeedRepository();
        mFeed = feedRepository.getPersonalFeed(user.getValue());
    }


}
