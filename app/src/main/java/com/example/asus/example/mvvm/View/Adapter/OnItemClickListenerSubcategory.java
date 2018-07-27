package com.example.asus.example.mvvm.View.Adapter;

import com.example.asus.example.mvvm.Model.Entities.Subcategory;

/**
 * Interface for the communication between the adapter and the Fragments
 * which implement the interface.
 * Transfers the Subcategory which was clicked on, from the Adapter to the Fragment.
 */
public interface OnItemClickListenerSubcategory {

    /**
     * method which handles the transfer of the clicked on Subcategory.
     *
     * @param subcategory which was clicked on.
     */
    void onItemClick(Subcategory subcategory);
}
