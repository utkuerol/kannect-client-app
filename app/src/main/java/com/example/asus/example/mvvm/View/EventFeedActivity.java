package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.example.mvvm.Model.Entities.Event;

/**
 * The Activity displayed when accessing an event. It shows informations about the event and all the posts
 * related to it.
 */
public class EventFeedActivity extends AppCompatActivity {

    private EventFeedViewModel viewModel = new EventFeedViewModel();
    //event from intent

    /**
     * Method which is called, when the Activity is first created.
     * Initializes the DataBinding.
     * @param savedInstanceState if the activity is being re-initialized after previously being shut down
     *                           then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     */
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set binding
        // get and set event from intent
    }

    /**
     * is the method allowing to reach the activity.
     * @param context is the context from which the activity gets accessed.
     * @param event the event ofwhich the feed is being displayed
     * @return the corresponding intent
     */
    public static Intent launchWithDetails(Context context, Event event) {
        // redirects from parameter context to this activity, takes user as parameter
        return null;
    }
}
