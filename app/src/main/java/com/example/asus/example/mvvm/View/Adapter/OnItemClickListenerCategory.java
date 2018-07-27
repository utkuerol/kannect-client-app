package com.example.asus.example.mvvm.View.Adapter;

import com.example.asus.example.mvvm.Model.Entities.Category;

/**
 * Interface for the communication between the adapter and the Fragments
 * which implement the interface.
 * Transfers the Category which was clicked on, from the Adapter to the Fragment.
 */
public interface OnItemClickListenerCategory {

    /**
     * method which handles the transfer of the clicked on Category.
     *
     * @param category which was clicked on.
     */
    void onItemClick(Category category);
}
