package com.example.asus.example.mvvm.Model.Repository;

import android.arch.lifecycle.MutableLiveData;

import com.example.asus.example.mvvm.Model.Entities.Message;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.WebServices.ServiceAPI;
import com.example.asus.example.mvvm.Model.WebServices.ServiceGenerator;

import java.util.List;

import retrofit2.Call;

/**
 * Repository which handles all the requests from the Viewmodel, regarding Message requests.
 */
public class MessageRepository {

    /**
     * Default Constructor
     */
    public MessageRepository() {}

    /**
     * Method to get all the received Messages from a User from the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param user which requested to see all his received Messages
     * @return List of all the received Messages as a MutableLiveData object
     */
    public MutableLiveData<List<Message>> getReceivedMessages(User user) {
        return null;
    }

    /**
     * Method to get all the Messages, which were sent by the user, from the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param user which requests all the messages which he sent
     * @return List of all sent messages by the user as a MutableLiveData object
     */
    public MutableLiveData<List<Message>> getSentMessages(User user) {
        return null;
    }

    /**
     * Method to indicate to the server that a message was sent by the user
     * @param message which will be sent
     */
    public void sendMessage(Message message) {

    }





}
