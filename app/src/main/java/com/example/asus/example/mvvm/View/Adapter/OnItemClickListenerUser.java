package com.example.asus.example.mvvm.View.Adapter;

import com.example.asus.example.mvvm.Model.Entities.User;

/**
 * Interface for the communication between the adapter and the Fragments
 * which implement the interface.
 * Transfers the User which was clicked on, from the Adapter to the Fragment.
 */
public interface OnItemClickListenerUser {

    /**
     * method which handles the transfer of the clicked on User.
     *
     * @param user which was clicked on.
     */
    void onItemClick(User user);
}
