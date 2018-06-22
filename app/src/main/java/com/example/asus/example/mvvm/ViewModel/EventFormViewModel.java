package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.ViewModel;
import android.view.View;

import com.example.asus.example.mvvm.Model.Entities.Event;

public class EventFormViewModel extends ViewModel {
    /**
     * the new object that will hold the input data .
     */
   private  Event event;
    /**
     * constructor
     */
    public EventFormViewModel() {
    }

    /**
     *The event will be created when clicking on the button "Create".
     * The user will be directed to the home page of the created event.
     * @param view
     */
    public void onCreateEventClicked(View view){

    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
