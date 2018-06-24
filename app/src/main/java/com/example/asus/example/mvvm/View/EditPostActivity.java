package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.ViewModel.PostViewModel;

/**
 * The Activity displayed to allow the user to edit a post that can be in a group, an activity or someone's profile.
 */
public class EditPostActivity extends AppCompatActivity {

    PostViewModel viewModel;
    //bin (can only be done with xml)


    /**
     * creates a EditPostActivity
     * @param viewModel adds the needed changes in the model and in the view
     */
    public EditPostActivity(PostViewModel viewModel) { //add the binding to the constructor manually :binding not possible without xml
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
     * redirects to this activity
     * @param context needed Application Information to launch this Activity.
     * @param post the post navigated to.
     * @return the Intent, which is used to redirect to this Activity.
     */
    public Intent launchWithDetails(Context context, Post post){ return new Intent(); }

    public PostViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(PostViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
