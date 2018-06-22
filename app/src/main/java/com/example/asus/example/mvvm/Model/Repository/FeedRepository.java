package com.example.asus.example.mvvm.Model.Repository;

import android.arch.lifecycle.MutableLiveData;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.WebServices.ServiceAPI;
import com.example.asus.example.mvvm.Model.WebServices.ServiceGenerator;

import java.util.List;

import retrofit2.Call;

/**
 * Repository which handles all the Request from the ViewModel, regarding Feed requests.
 */
public class FeedRepository {

    /**
     * Default Constructor
     */
    public FeedRepository() {

    }

    /**
     * Method to get all the Post that belong on an Users feed.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param user which feed will be generated
     * @return List of all the Posts, which belong to the Users feed as a MutableLiveData object
     */
    public MutableLiveData<List<Post>> getPersonalFeed(User user) {
        return null;
    }

    /**
     * Method to get all the Post that belong on a Groups feed.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param group which feed will be generated
     * @return List of all the Posts, which belong to the Groups feed as a MutableLiveData object
     */
    public MutableLiveData<List<Post>> getGroupFeed(Group group) {
        return null;
    }

    /**
     * Method to get all the Post that belong on a Groups feed.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param event which feed will be generated
     * @return List of all the Posts, which belong to the Groups feed as a MutableLiveData object
     */
    public MutableLiveData<List<Post>> getEventFeed(Event event) {
        return null;
    }
}
