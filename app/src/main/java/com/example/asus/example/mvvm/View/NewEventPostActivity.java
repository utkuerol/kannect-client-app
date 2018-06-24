package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.ViewModel.ItemEventViewModel;

public class NewEventPostActivity extends AppCompatActivity {

    private ItemEventViewModel viewModel;
    //binding


    /**
     * creates a newPostActivity
     * @param viewModel addes the needed changes in the model and in the view
     */
    public NewEventPostActivity(ItemEventViewModel viewModel) { //add the binding to the constructor manually :binding not possible without xml
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
     * the event, which this view needs, being the event to which the user navigated.
     * @param context needed Application Information to launch this Activity.
     * @param event the event navigated to.
     * @return the Intent, which is used to redirect to this Activity.
     */
    public void launchWithDetails(Context context, Event event){ }

    public ItemEventViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(ItemEventViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
