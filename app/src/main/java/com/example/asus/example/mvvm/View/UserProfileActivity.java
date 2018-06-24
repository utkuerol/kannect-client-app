package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.UserViewModel;

/**
 * User Profile Activity to show all Posts for this User
 */
public class UserProfileActivity extends AppCompatActivity {


    UserViewModel viewModel;

    /**
     * launch this Activity and send with it a user
     *
     * @param context Context of the application
     * @param user    user to give for the next Activity
     * @return Intent Object for the two activities
     */
    public static Intent launchWithDetails(Context context, User user) {
        // redirects from parameter context to this activity, takes user as parameter
    }

    /**
     * Method which is called, when the Activity is first created.
     * Initializes the DataBinding.
     * @param savedInstanceState if the activity is being re-initialized after previously being shut down
     *                           then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     * @param persistentState if the activity is being re-initialized after previously being shut down or powered off
     *                        then this Bundle contains the data it most recently supplied to outPersistentState in onSaveInstanceState(Bundle).
     */
    @Override public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        // set binding
        // get and set user from intent
        // set adapter
        // find view model
        // viewmodel.observe(this) --- sync with adapter ...
    }



}
