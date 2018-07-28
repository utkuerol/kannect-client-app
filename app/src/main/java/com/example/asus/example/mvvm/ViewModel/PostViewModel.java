package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.FeedRepository;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;

import java.util.List;

public class PostViewModel extends ViewModel {

    private MutableLiveData<List<Post>> posts = new MutableLiveData<>();
    private MutableLiveData<User> currentUser = new MutableLiveData<>();
    private FeedRepository feedRepository;
    private Context context;

    /**
     * Initializes all repository variables.
     * Retrieves currently logged in user from storage via SharedPreferences and the
     * UserRepository.
     *
     * @param context of the Application.
     */
    public void init(Context context) {
        feedRepository = new FeedRepository();
        UserRepository userRepository = new UserRepository();
        this.context = context;
        SharedPreferences myPrefs = context.getSharedPreferences("CurrentUser", 0);
        currentUser = userRepository.getUserByID(myPrefs.getInt("CurrentUserId", 0));
    }

    /**
     * sets the list of posts, so that only posts are in the list, that belong to the currently
     * logged in users feed.
     */
    public void setPostsToPersonalFeed() {
            this.posts = feedRepository.getPersonalFeed(currentUser.getValue());
    }

    /**
     * method to get the list of posts that will be shown in the users feed.
     * @return list of posts as a MutableLiveData object.
     */
    public MutableLiveData<List<Post>> getPosts() {
        return posts;
    }

    /**
     * method to get the currently logged in user.
     * @return currently logged in user as a MutableLiveData object.
     */
    public MutableLiveData<User> getCurrentUser() {
        return currentUser;
    }

    /**
     * sets the currently logged in user.
     * @param currentUser which will be set.
     */
    public void setCurrentUser(MutableLiveData<User> currentUser) {
        this.currentUser = currentUser;
    }
}
