package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.ViewModel.ItemGroupViewModel;

public class NewGroupePostActivity extends AppCompatActivity {

    private ItemGroupViewModel viewModel;
    //binding


    /**
     * creates a newPostActivity
     * @param viewModel addes the needed changes in the model and in the view
     */
    public NewGroupePostActivity(ItemGroupViewModel viewModel) { //add the binding to the constructor manually :binding not possible without xml
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
     * redirects to this activity using the current Context of the Application and
     * the group, which this view needs, being the group to which the user navigated.
     * @param context needed Application Information to launch this Activity.
     * @param group the group navigated to.
     * @return the Intent, which is used to redirect to this Activity.
     */
    public void launchWithDetails(Context context, Group group){ }

    public ItemGroupViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(ItemGroupViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
