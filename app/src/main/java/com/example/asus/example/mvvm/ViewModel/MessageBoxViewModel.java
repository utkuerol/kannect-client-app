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
    public MessageBoxViewModel(List<Message> mSentMessages,
                               List<Message> mReceivedMessages,
                               MessageRepository repository) {
        MutableLiveData<List<Message>> mSent = new MutableLiveData<List<Message>>();
        mSent.setValue(mSentMessages);
        this.mSentMessages = mSent;
        MutableLiveData<List<Message>> mReceived = new MutableLiveData<List<Message>>();
        mReceived.setValue(mReceivedMessages);
        this.mReceivedMessages = mReceived;
        this.repository = repository;
    }

    /**
     * This method allows the navigation to a new activity where a message will be created and sent.
     */
    public void createNewMessage() {

    }

    public void setmSentMessages(List<Message> mSentMessages) {
        MutableLiveData<List<Message>> mSent = new MutableLiveData<List<Message>>();
        mSent.setValue(mSentMessages);
        this.mSentMessages = mSent;
    }

    public void setmReceivedMessages(List<Message> mReceivedMessages) {
        MutableLiveData<List<Message>> mReceived = new MutableLiveData<List<Message>>();
        mReceived.setValue(mReceivedMessages);
        this.mReceivedMessages = mReceived;
    }

    public void setRepository(MessageRepository repository) {
        this.repository = repository;
    }

    public List<Message> getmSentMessages() {

        return mSentMessages.getValue();
    }

    public List<Message> getmReceivedMessages() {
        return mReceivedMessages.getValue();
    }

    public MessageRepository getRepository() {
        return repository;
    }


}
