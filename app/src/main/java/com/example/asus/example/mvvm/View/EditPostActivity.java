package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.ViewModel.PostViewModel;

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
