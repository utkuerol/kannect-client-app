package com.example.asus.example.mvvm.Model.Repository;

import android.accounts.Account;
import android.arch.lifecycle.MutableLiveData;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.User;

import java.util.List;

/**
 * Repository which handles all the requests from the Viewmodel, User Message requests.
 */
public class UserRepository {

    /**
     * Default Constructor.
     */
    public UserRepository() {

    }
    /**
     * Method to get all User, from the server, which match the Search Query. Sends Search Query to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param searchQuery typed in by User.
     * @return List of Users, which match the Search Query, as a MutableLiveData object.
     */
    public MutableLiveData<List<User>> getUsers(String searchQuery) {return null;}

    /**
     * Method to indicate to the server, that a User subscribed to another User. Sends two User objects to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param subscriber User who subscribed another User.
     * @param subscribed User who was subscribed to.
     */
    public void subscribeUser(User subscriber, User subscribed) {}

    /**
     * Method to indicate to the server, that a User unsubscribed to another User. Sends two User object to the Server
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param subscriber User who unsubscribed to another User.
     * @param subscribed User who was unsubscribed to.
     */
    public void unsubscribeUser(User subscriber, User subscribed) {}

    /**
     * Method to indicate to the server, that the User joined a Group. Sends a User and a Group object to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param user which joined a Group.
     * @param group which the User left.
     */
    public void joinGroup(User user, Group group){}

    /**
     * Method to indicate to the server, that the User left a Group. Sends a user and a Group object to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param user who left a group.
     * @param group which the User left.
     */
    public void leaveGroup(User user, Group group){}

    /**
     * Method to indicate to the Server, that a User wants to participate in an Event. Sends a User and a Event object to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param user who wants to participate in an Event.
     * @param event in which the User wants to participate in.
     */
    public void participateEvent(User user, Event event) {}

    /**
     * Method to indicate to the Server, that a User doesn´t want to participate in an Event anymore. Sends a User and an Event Object to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param user who wants to leave an Event
     * @param event which the User wants to leave.
     */
    public void leaveEvent(User user, Event event) {}

    public User loginUser(GoogleSignInAccount account){

        //parse
        //connection with the server
        return null;
    }

}
