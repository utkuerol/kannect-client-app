package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.example.mvvm.ViewModel.GroupViewModel;

/**
 * Activity diplaying all groups
 */
public class GroupsFragment extends AppCompatActivity {

    GroupViewModel viewModel = new GroupViewModel(this);
    //Group from intent

    /**
     * redirects to this activity
     * @param context needed Application Information to launch this Activity
     * @return the Intent, which is used to redirect to this Activity.
     */
    public static Intent launchWithDetails(Context context) {
        // redirects from parameter context to this activity, takes user as parameter
        return null;
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
}
