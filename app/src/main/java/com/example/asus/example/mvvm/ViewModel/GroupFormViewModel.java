package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import com.example.asus.example.mvvm.Model.Entities.Group;


public class GroupFormViewModel extends ViewModel {
    /**
     * this object will contain the input data .
     */
    private Group group;

    /**
     * constructor
     */
    public GroupFormViewModel() {
    }

    /**
     * This method creates a Group with the filled information when clicking
     * on the button " Create Group"
     */
    public Group onCreateGroupClicked(View view) {
        return new Group();
    }

}
