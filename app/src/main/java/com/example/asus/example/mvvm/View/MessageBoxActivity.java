package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
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

    /**
     * Method which is called, when the Activity is first created.
     * Initializes the DataBinding.
     * @param savedInstanceState if the activity is being re-initialized after previously being shut down
     *                           then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     * @param persistentState if the activity is being re-initialized after previously being shut down or powered off
     *                        then this Bundle contains the data it most recently supplied to outPersistentState in onSaveInstanceState(Bundle).
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    /**
     * Is the method allowing to reach the activity
     * @param context context needed Application Information to launch this Activity.
     */
    public void launchWithDetails(Context context){ }



    public MessageBoxViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(MessageBoxViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
