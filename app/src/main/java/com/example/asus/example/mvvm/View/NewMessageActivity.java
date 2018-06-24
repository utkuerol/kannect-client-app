package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
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
     * redirects to this activity using the current Context of the Application
     * @param context needed Application Information to launch this Activity.
     * @return the Intent, which is used to redirect to this Activity.
     */
    public Intent launchWithDetails(Context context){return null; }
}
