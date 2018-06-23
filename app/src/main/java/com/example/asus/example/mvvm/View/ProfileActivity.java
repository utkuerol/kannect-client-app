package com.example.asus.example.mvvm.View;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asus.example.R;
//import com.example.asus.example.databinding.ActivityMainBinding;

public class ProfileActivity extends AppCompatActivity {

    //ActivityMainBinding activityProfileBinding = DataBindingUtil.setContentView(this,R.layout.activity_profile);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}

