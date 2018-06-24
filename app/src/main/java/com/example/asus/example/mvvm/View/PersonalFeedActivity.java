package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.ViewModel.PostViewModel;

/**
 * Personal Feed Activity to show all Posts for this signed user of his groups , posts , events
 */
public class PersonalFeedActivity extends AppCompatActivity {

    PostViewModel viewModel;


    /**
     * Is the method allowing to reach the activity
     */
    public static Intent launchWithDetails(Context context, Event event) {
        // redirects from parameter context to this activity, takes user as parameter
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set binding
        // get and set event from intent
    }
}
