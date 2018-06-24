package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.example.mvvm.Model.Entities.Subcategory;

/**
 * Activity class for the view of creating a new Event in a Subcategory.
 * Uses the ItemSubcategoryViewModel as its ViewModel.
 */
public class NewEventInSubcategoryActivity extends AppCompatActivity{

    /**
     * Method which is called, when the Activity is first created.
     * Initializes the DataBinding and the subcategory, which it got from the intent of the launchWithDetail method.
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
     * the Subcategory, which this view needs, being the Subcategory to which the user navigated.
     * @param context needed Application Information to launch this Activity.
     * @param subcategory the user navigated to.
     * @return the Intent, which is used to redirect to this Activity.
     */
    public static Intent launchWithDetails(Context context, Subcategory subcategory) {
        return null;
    }

}
