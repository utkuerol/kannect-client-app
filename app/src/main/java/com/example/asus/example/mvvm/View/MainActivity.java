package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.asus.example.R;
import com.example.asus.example.databinding.ActivityMainBinding;

import com.example.asus.example.mvvm.Model.User;
import com.example.asus.example.mvvm.ViewModel.LoginViewModel;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);


        activityMainBinding.setViewModel(



                ViewModelProviders.of(this).get(LoginViewModel.class));

        LoginViewModel loginViewModel =
                ViewModelProviders.of(this).get(LoginViewModel.class);

        loginViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                showUser(user);
            }
        });



    }

    public void showUser(User user) {
        Toasty.success(this,"User changed : "+user.toString(),Toast.LENGTH_SHORT).show();

    }


}
