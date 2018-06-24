package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;

public class GroupFeedActivity extends AppCompatActivity {

    GroupFeedViewModel viewModel = new GRoupFeedViewModel();
    //group from intent

    @Override protected void onCreate(Bundle savedInstanceState) {
        // set binding
        // get and set group from intent
    }

    public static Intent launchWithDetails(Context context, MutableLiveData<Group> group) {
        // redirects from parameter context to this activity, takes user as parameter
    }
}
