package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.example.mvvm.ViewModel.ItemUserViewModel;

public class SubscriptionsActivity extends AppCompatActivity {

    ItemUserViewModel viewModel;
    //binding

    /**
     * creates a SubscriptionsActivity
     * @param viewModel addes the needed changes in the model and in the view
     */
    public SubscriptionsActivity(ItemUserViewModel viewModel) { //add the binding to the constructor manually :binding not possible without xml
        this.viewModel = viewModel;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Is the method allowing to reach the activity
     */
    public void launchWithDetails(Context context){ }

    public ItemUserViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(ItemUserViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
