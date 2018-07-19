package com.example.asus.example.mvvm.Model.Repository;

import android.arch.lifecycle.MutableLiveData;

import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.WebServices.ServiceAPI;
import com.example.asus.example.mvvm.Model.WebServices.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Repository which handles all the requests from the Viewmodel, regarding Group requests.
 */
public class GroupRepository {

    /**
     * Default Constructor
     */
    public  GroupRepository() {}

    /**
     * Method to get all the Groups from the server, which match the search query.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param searchQuery typed in by user
     * @return List of all the Groups which match the search query as a MutableLiveData object
     */
    public MutableLiveData<List<Group>> getGroups(String searchQuery) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<List<Group>> call = client.getSearchGroups(searchQuery);
        final MutableLiveData<List<Group>> result = new MutableLiveData<>();

        call.enqueue(new Callback<List<Group>>() {
            @Override
            public void onResponse(Call<List<Group>> call, Response<List<Group>> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Group>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }



    /**
     * Method to notify Server that a Group was created. This Method transfers a Group object to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param group created Group
     */
    public void createGroup(Group group) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<Group> call = client.createGroup(group);
        call.enqueue(new Callback<Group>() {
            @Override
            public void onResponse(Call<Group> call, Response<Group> response) {

            }

            @Override
            public void onFailure(Call<Group> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


    /**
     * Method to notify Server that an existing Group was deleted. This Method transfers the Group object to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param groupID which will be deleted
     */
    public void deleteGroup(long groupID) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<Group> call = client.deleteGroup(groupID);
        call.enqueue(new Callback<Group>() {
            @Override
            public void onResponse(Call<Group> call, Response<Group> response) {

            }

            @Override
            public void onFailure(Call<Group> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }






}
