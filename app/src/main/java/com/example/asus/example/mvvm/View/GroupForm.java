package com.example.asus.example.mvvm.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.example.R;
//import com.example.asus.example.databinding.ActivityMainBinding;


/**
 * This class manipulate the lifecycle of the Group form . It extends all methods from the class AppCompatActivity.
 * It implements the methods onCreate, onStop, onResume..
 */
public class GroupForm extends AppCompatActivity {
    /**
     * a variable to  create a link between UI layer and the underlying data model of the group that holds the information to display.
     */
    //ActivityMainBinding groupFormBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_form);

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }



}
