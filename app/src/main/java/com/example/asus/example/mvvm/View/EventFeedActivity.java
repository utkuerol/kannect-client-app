package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.example.mvvm.Model.Entities.Event;

public class EventFeedActivity extends AppCompatActivity {

    //event from intent

    @Override protected void onCreate(Bundle savedInstanceState) {
        // set binding
        // get and set event from intent
    }

    public static Intent launchWithDetails(Context context, Event event) {
        // redirects from parameter context to this activity, takes user as parameter
    }
}
