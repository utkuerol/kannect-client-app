package com.example.asus.example.mvvm.Model.Repository;

import android.arch.lifecycle.MutableLiveData;

import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.WebServices.ServiceAPI;
import com.example.asus.example.mvvm.Model.WebServices.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
     * @param userID which feed will be generated
     * @return List of all the Posts, which belong to the Users feed as a MutableLiveData object
     */
    public MutableLiveData<List<Post>> getPersonalFeed(long userID) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<List<Post>> call = client.getPersonalFeed(userID);
        final MutableLiveData<List<Post>> result = new MutableLiveData<>();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                t.printStackTrace();
            }
        });


        return result;
    }

    /**
     * Method to get all the Post that belong on a Groups feed.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param groupID group which feed will be generated
     * @return List of all the Posts, which belong to the Groups feed as a MutableLiveData object
     */
    public MutableLiveData<List<Post>> getGroupFeed(long groupID) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<List<Post>> call = client.getGroupFeed(groupID);
        final MutableLiveData<List<Post>> result = new MutableLiveData<>();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                result.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return result;
    }

    /**
     * Method to get all the Post that belong on a Groups feed.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param eventID which feed will be generated
     * @return List of all the Posts, which belong to the Groups feed as a MutableLiveData object
     */
    public MutableLiveData<List<Post>> getEventFeed(long eventID) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<List<Post>> call = client.getEventFeed(eventID);
        final MutableLiveData<List<Post>> result = new MutableLiveData<>();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return result;
    }
}
