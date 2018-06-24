package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.os.Bundle;
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
     * @param viewModel addes the needed changes in the model and in the view
     */
    public EditPostActivity(PostViewModel viewModel) { //add the binding to the constructor manually :binding not possible without xml
        this.viewModel = viewModel;
    }

    /**
     * Method which is called, when the Activity is first created.
     * Initializes the DataBinding.
     * @param savedInstanceState if the activity is being re-initialized after previously being shut down
     *                           then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
                            then this Bundle contains the data it most recently supplied to outPersistentState in onSaveInstanceState(Bundle).
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Is the method allowing to reach the activity
     */
    public void launchWithDetails(Context context, Post post){ }

    public PostViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(PostViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
