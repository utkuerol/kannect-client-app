package com.example.asus.example.mvvm.View.Adapter;

import com.example.asus.example.mvvm.Model.Entities.Group;

/**
 * Interface for the communication between the adapter and the Fragments
 * which implement the interface.
 * Transfers the Group which was clicked on, from the Adapter to the Fragment.
 */
public interface OnItemClickListenerGroup {

    /**
     * method which handles the transfer of the clicked on Group.
     *
     * @param group which was clicked on.
     */
    void onItemClick(Group group);
}
