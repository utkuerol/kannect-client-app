package com.example.asus.example.mvvm.ViewModel;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Post;

public class EditEventActivity extends AppCompatActivity {

    EventViewModel viewModel;
    //bin (can only be done with xml)


    /**
     * creates a EditEventActivity
     * @param viewModel addes the needed changes in the model and in the view
     */
    public EditEventActivity(EventViewModel viewModel) { //add the binding to the constructor manually :binding not possible without xml
        this.viewModel = viewModel;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Is the method allowing to reach the activity
     */
    public void launchWithDetails(Context context, Event event){ }

    public EventViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(EventViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
