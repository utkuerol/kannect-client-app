package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Activity class for the view of the result of a search query by the user.
 * Uses the SearchResultViewModel class as its ViewModel.
 */
public class SearchResultActivity extends AppCompatActivity {

    /**
     * Method which is called, when the Activity is first created.
     * Initializes the DataBinding and the search query , which it got from the intent of the launchWithDetail method.
     * @param savedInstanceState if the activity is being re-initialized after previously being shut down
     *                           then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     * @param persistentState if the activity is being re-initialized after previously being shut down or powered off
     *                        then this Bundle contains the data it most recently supplied to outPersistentState in onSaveInstanceState(Bundle).
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    /**
     * redirects to this activity using the current Context of the Application and
     * the search query, which this view needs, being the search query  the user typed in.
     * @param context needed Application Information to launch this Activity.
     * @param searchQuery the user typed in.
     * @return the Intent, which is used to redirect to this Activity.
     */
    public static Intent launchWithDetails(Context context, String searchQuery) {

    }
}
