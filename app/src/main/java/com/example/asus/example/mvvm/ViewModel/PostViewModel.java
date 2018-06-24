package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Repository.FeedRepository;

import java.util.List;

/**
 * ViewModel class for Personal Feed that is responsible for preparing and managing the data for Views,
 * which need a list of posts representing a personal feed, by handling the communication of the View with the
 * FeedRepository class, which has the feed business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class PostViewModel extends ViewModel {


    private MutableLiveData<List<Post>> personalFeed;
    private Context context;
    private FeedRepository feedRepository;


    /**
     * Constructs a new instance of this with the given application context.
     *
     * @param context of the application.
     */
    public PostViewModel(Context context) {
        this.context = context;
    }

    /**
     * Sets the list of posts to the personal feed received from the repository.
     */
    public void setPersonalFeed() {
    }

    /**
     * Gets the personal feed.
     *
     * @return observable list of posts.
     */
    public MutableLiveData<List<Post>> getPersonalFeed() {
        return personalFeed;
    }


}
