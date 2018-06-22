package com.example.asus.example.mvvm.Model.Repository;

import android.arch.lifecycle.MutableLiveData;

import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.WebServices.ServiceAPI;
import com.example.asus.example.mvvm.Model.WebServices.ServiceGenerator;

import java.util.List;

import retrofit2.Call;

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
        return null;
    }



    /**
     * Method to notify Server that a Group was created. This Method transfers a Group object to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param group created Group
     */
    public void createGroup(Group group) {

    }


    /**
     * Method to notify Server that an existing Group was deleted. This Method transfers the Group object to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param group which will be deleted
     */
    public void deleteGroup(Group group) {

    }


    /**
     * Method to notify Server that an existing Group was edited. This Method transfers the edited Group to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param group edited Group
     */
    public void editGroup(Group group) {

    }




}
