package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.example.mvvm.Model.Entities.User;

public class MainFeedActivity  extends AppCompatActivity {
    //user from intent


    @Override protected void onCreate(Bundle savedInstanceState) {
        // set binding
        // get and set user from intent
    }

    public static Intent launchDetail(Context context, User user) {
        // redirects from parameter context to this activity, takes user as parameter
        return null;
    }

}
