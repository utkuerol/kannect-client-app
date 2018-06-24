package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.asus.example.mvvm.Model.Entities.Message;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.MessageRepository;

public class NewMessageViewModel extends ViewModel {

    MutableLiveData<Message> message;
    MutableLiveData<User> receiver;
    MessageRepository repository;

    /**
     * creates a new NewMessageViewModel to apply the needed changes in Model and in view.
     * @param message Message to be sent
     * @param receiver user receiving the message
     * @param repository Repository to get informations from
     */
    public NewMessageViewModel(MutableLiveData<Message> message, MutableLiveData<User> receiver, MessageRepository repository) {
        this.message = message;
        this.receiver = receiver;
        this.repository = repository;
    }

    /**
     * This methods sends the given messages to the chosen user
     * @param receiver the user to which is the message going to be sent to
     * @param Message The message that is going to be sent
     */
    public void sendMessage(MutableLiveData<User> receiver, MutableLiveData<Message> Message){

    }
}
