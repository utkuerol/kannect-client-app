package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

    @Override protected void onCreate(Bundle savedInstanceState) {
        // set binding
        // get and set user from intent
        // set adapter
        // find view model
        // viewmodel.observe(this) --- sync with adapter ...
    }



}
