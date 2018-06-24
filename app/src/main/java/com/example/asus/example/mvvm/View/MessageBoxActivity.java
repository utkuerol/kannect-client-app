package com.example.asus.example.mvvm.View;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.example.mvvm.ViewModel.MessageBoxViewModel;

/**
 * The activity appearing when the user checks his messages.
 */
public class MessageBoxActivity extends AppCompatActivity {

    //binding (can only be done with an xml file)
    private MessageBoxViewModel viewModel;

    /**
     * creates a new MessageBoxActivity
     * @param viewModel viewModel applying the changes on model and view when needed
     */
    public MessageBoxActivity(MessageBoxViewModel viewModel) {
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


    public MessageBoxViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(MessageBoxViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
