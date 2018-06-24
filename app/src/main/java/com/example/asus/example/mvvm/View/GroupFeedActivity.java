package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.ViewModel.GroupViewModel;

/**
 * Activity displaying informations about the group and its posts
 */
public class GroupFeedActivity extends AppCompatActivity {

    GroupViewModel viewModel = new GroupViewModel(this);
    //group from intent

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
     * redirects to this activity
     * @param context needed Application Information to launch this Activity.
     * @param group the group navigated to.
     * @return the Intent, which is used to redirect to this Activity.
     */
    public static Intent launchWithDetails(Context context, Group group) {
    }
}
