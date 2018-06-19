package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.asus.example.R;
import com.example.asus.example.databinding.ActivityMainBinding;
import com.example.asus.example.mvvm.Interface.LoginResultCallBacks;
import com.example.asus.example.mvvm.ViewModel.LoginViewModel;
import com.example.asus.example.mvvm.ViewModel.LoginViewModelFactory;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements LoginResultCallBacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(this,new LoginViewModelFactory(this)).get(LoginViewModel.class));
    }

    @Override
    public void onSuccess(String Message) {
        Toasty.success(this,"Login success",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String Message) {
        Toasty.error(this,"Login Error",Toast.LENGTH_SHORT).show();
    }
}
