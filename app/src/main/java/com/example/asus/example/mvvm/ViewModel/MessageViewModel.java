package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.asus.example.mvvm.Model.Entities.Message;
import com.example.asus.example.mvvm.Model.Repository.MessageRepository;

/**
 * ViewModel applying the changes in every message in the displayed MessageBox.
 */
public class MessageViewModel extends ViewModel {

    MutableLiveData<Message> message;
    MessageRepository repository;

    /**
     * generates a new MessageViewModel
     * @param message is any message involving the logedin user (sent by or to him)
     * @param repository gives information about message
     */
    public MessageViewModel(Message message, MessageRepository repository) {
        MutableLiveData<Message> m = new MutableLiveData<Message>();
        m.setValue(message);
        this.message = m;
        this.repository = repository;
    }


    public Message getMessage() {
        return message.getValue();
    }

    public void setMessage(Message message) {
        MutableLiveData<Message> m = new MutableLiveData<Message>();
        m.setValue(message);
        this.message = m;
    }

    public MessageRepository getRepository() {
        return repository;
    }

    public void setRepository(MessageRepository repository) {
        this.repository = repository;
    }
}
