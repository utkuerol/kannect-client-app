package com.example.asus.example.mvvm.View.Adapter;

import com.example.asus.example.mvvm.Model.Entities.Post;

/**
 * Interface for the communication between the adapter and the Fragments
 * which implement the interface.
 * Transfers the Post which was clicked on, from the Adapter to the Fragment.
 */
public interface OnItemClickListenerPost {

    /**
     * method which handles the transfer of the clicked on Post.
     *
     * @param post which was clicked on.
     */
    void onItemClick(Post post);
}
