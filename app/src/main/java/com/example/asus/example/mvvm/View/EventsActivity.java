package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.ViewModel.EventViewModel;

/**
 * Activity started from the mainmenu and displaying all in app registered events
 */
public class EventsActivity extends AppCompatActivity {

    EventViewModel viewModel = new EventViewModel(this);
    //event from intent

    /**
     * redirects to this activity using the current Context of the Application and
     * the event, which this view needs, being the event to which the user navigated.
     * @param context needed Application Information to launch this Activity.
     * @param event the user navigated to.
     * @return the Intent, which is used to redirect to this Activity.
     */
    public static Intent launchWithDetails(Context context, Event event) {
        // redirects from parameter context to this activity, takes user as parameter
        return null;
    }

    /**
     * Method which is called, when the Activity is first created.
     * Initializes the DataBinding and the post, which it got from the intent of the launchWithDetail method.
     * @param savedInstanceState if the activity is being re-initialized after previously being shut down
     *                           then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set binding
        // get and set event from intent
    }
}
