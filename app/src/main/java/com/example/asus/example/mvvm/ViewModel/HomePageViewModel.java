package com.example.asus.example.mvvm.ViewModel;

import android.view.View;

import com.example.asus.example.mvvm.Model.Entities.Group;

public class HomePageViewModel {
    /**
     * This method opens the messages when clicking on the Button "Messages" in the principal menu.
     * @param view
     */
    public void onMessageBoxClicked(View view){

    }

    /**
     *
     * @param view
     * @return the home page of the group on which the user has clicked.
     */
    public Group onGroupClicked(View view){
     return  new Group();
    }

    /**
     * This method open all events in new page.
     * @param view
     */
    public void onEventsClicked(View view){

    }

    /**
     * This method open all feeds in a new page.
     * @param view
     */
    public void onFeedClicked(View view){

    }

    /**
     * the form of a new group will be opened.
     * @param view
     */
    public void onCreateNewGroupClicked(View view){

    }

    /**
     * the form of a new event will be opened.
     * @param view
     */
    public void onCreateNewEventClicked(View view){

    }
}
