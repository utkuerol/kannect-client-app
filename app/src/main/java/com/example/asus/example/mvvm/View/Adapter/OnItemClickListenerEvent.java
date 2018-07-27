package com.example.asus.example.mvvm.View.Adapter;

import com.example.asus.example.mvvm.Model.Entities.Event;

/**
 * Interface for the communication between the adapter and the Fragments
 * which implement the interface.
 * Transfers the Event which was clicked on, from the Adapter to the Fragment.
 */
public interface OnItemClickListenerEvent {

    /**
     * method which handles the transfer of the clicked on Event.
     *
     * @param event which was clicked on.
     */
    void onItemClick(Event event);
}
