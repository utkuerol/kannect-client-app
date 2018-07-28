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
     * @param user which feed will be generated
     * @return List of all the Posts, which belong to the Users feed as a MutableLiveData object
     */
    public MutableLiveData<List<Post>> getPersonalFeed(User user) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<List<Post>> call = client.getPersonalFeed(user.getId());
        final MutableLiveData<List<Post>> result = new MutableLiveData<>();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    result.setValue(response.body());
                }
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
     * @param group group which feed will be generated
     * @return List of all the Posts, which belong to the Groups feed as a MutableLiveData object
     */
    public MutableLiveData<List<Post>> getGroupFeed(Group group) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<List<Post>> call = client.getGroupFeed(group.getId());
        final MutableLiveData<List<Post>> result = new MutableLiveData<>();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    result.setValue(response.body());
                }

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
     * @param event which feed will be generated
     * @return List of all the Posts, which belong to the Groups feed as a MutableLiveData object
     */
    public MutableLiveData<List<Post>> getEventFeed(Event event) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<List<Post>> call = client.getEventFeed(event.getId());
        final MutableLiveData<List<Post>> result = new MutableLiveData<>();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    result.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return result;
    }
}
