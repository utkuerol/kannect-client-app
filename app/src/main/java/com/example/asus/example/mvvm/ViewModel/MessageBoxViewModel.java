package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.asus.example.mvvm.Model.Entities.Message;
import com.example.asus.example.mvvm.Model.Repository.MessageRepository;

import java.util.List;


/**
 * ViewModel belonging to MessageBoxActivity. It applies the needed changes on both sides (View and Model)
 * when needed.
 */
public class MessageBoxViewModel extends ViewModel {

    private MutableLiveData<List<Message>> mSentMessages;
    private MutableLiveData<List<Message>> mReceivedMessages;
    private MessageRepository repository;

    /**
     * generates a new MessageViewModel using the given parametres.
     * @param mSentMessages list containing all the messages sent by the logedin user
     * @param mReceivedMessages list containing all the messages received by the loged in user
     * @param repository allows getting information about the messages
     */
    public MessageBoxViewModel(MutableLiveData<List<Message>> mSentMessages,
                               MutableLiveData<List<Message>> mReceivedMessages,
                               MessageRepository repository) {
        this.mSentMessages = mSentMessages;
        this.mReceivedMessages = mReceivedMessages;
        this.repository = repository;
    }

    /**
     * This method allows the navigation to a new activity where a message will be created and sent.
     */
    public void createNewMessage() {

    }

    public void setmSentMessages(MutableLiveData<List<Message>> mSentMessages) {
        this.mSentMessages = mSentMessages;
    }

    public void setmReceivedMessages(MutableLiveData<List<Message>> mReceivedMessages) {
        this.mReceivedMessages = mReceivedMessages;
    }

    public void setRepository(MessageRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<List<Message>> getmSentMessages() {

        return mSentMessages;
    }

    public MutableLiveData<List<Message>> getmReceivedMessages() {
        return mReceivedMessages;
    }

    public MessageRepository getRepository() {
        return repository;
    }


}
