package com.example.asus.example.mvvm.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.asus.example.R;
import com.example.asus.example.databinding.ActivityMainBinding;

public class HomePage extends AppCompatActivity {
    ActivityMainBinding homePageBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
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
