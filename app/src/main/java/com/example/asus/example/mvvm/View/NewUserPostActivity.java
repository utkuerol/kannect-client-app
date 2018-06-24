package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemUserViewModel;

public class NewUserPostActivity extends AppCompatActivity {

    private ItemUserViewModel viewModel;
    //binding


    /**
     * creates a newPostActivity
     * @param viewModel addes the needed changes in the model and in the view
     */
    public NewUserPostActivity(ItemUserViewModel viewModel) { //add the binding to the constructor manually :binding not possible without xml
        this.viewModel = viewModel;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Is the method allowing to reach the activity
     */
    public void launchWithDetails(Context context, User user){ }

    public ItemUserViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(ItemUserViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
