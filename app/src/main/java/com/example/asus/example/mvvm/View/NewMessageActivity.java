package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.example.mvvm.ViewModel.NewMessageViewModel;


/**
 * Activity perceived when sending a new messaging.
 */
public class NewMessageActivity extends AppCompatActivity {

    //binding
    private Context context;
    private NewMessageViewModel viewModel;

    /**
     * creates a new NewMessageActivity
     * @param context
     * @param viewModel viewModel allowing changes in the view or the model as needed
     */
    public NewMessageActivity(Context context, NewMessageViewModel viewModel) {
        this.context = context;
        this.viewModel = viewModel;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Is the method allowing to reach the activity
     */
    public void launchWithDetails(){ }
}
