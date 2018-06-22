package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;

public class EventViewModel extends ViewModel {


    /**
     *
     * @return the number of Participants in this Event
     */
    public int CountParticipants() {
        return 0;

    }

    /**
     * when clicking on the button Participants in the home page of an event,
     * it will be shown, how many participants will be in the event.
     */
    public void showParticipants(View view){

    }


    /**
     *
     * @return the Post when clicking on  it to show all its  details.
     */
    public Post onOpenPostClicked(View view){
        return new Post();
    }

    /**
     * This method add a User to an Event.
     */
    public void onParticipateEventClicked(User user){

    }

    /**
     *
     * @param view
     */
    public void onAddPostClicked(View view){

    }

}
