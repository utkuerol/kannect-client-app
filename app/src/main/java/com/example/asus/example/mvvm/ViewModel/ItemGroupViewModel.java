package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;

import java.util.List;

import javax.swing.text.View;

public class ItemGroupViewModel extends ViewModel {

    private MutableLiveData<Group> chosenGroup;
    Context context;

    public ItemGroupViewModel(MutableLiveData<Group> chosenGroup, Context context) {
        this.chosenGroup = chosenGroup;
        this.context = context;
    }

    public void onItemClick(View view) {
        //context.startActivity(GroupFeedActivity.launchWithDetails(view.getContext(), mChosenEvent));
    }

    public MutableLiveData<Group> getChosenGroup() {
        return chosenGroup;
    }

    public void setChosenGroup(MutableLiveData<Group> group) {}



    public String getName() {
    }

    public String getDescription() {
    }

    public User getCreator() {
    }

    public String getCreatorName() {

    }

    public Category getCategory() {
    }

    public Subcategory getSubcategory() {
    }

    public String getImageURl() {
    }

    public List<User> getMembers() {
    }
}
