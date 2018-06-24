package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Repository.FeedRepository;

import java.util.List;

public class PostViewModel extends ViewModel {

    private MutableLiveData<List<Post>> personalFeed;
    private Context context;

    private FeedRepository feedRepository;

    public PostViewModel(Context context) {
        this.context = context;
    }

    public void setPersonalFeed(List<Post> personalFeed) {
        MutableLiveData<List<Post>> pF = new MutableLiveData<List<Post>>();
        this.personalFeed = pF;
    }

}
