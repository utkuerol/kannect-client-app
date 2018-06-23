package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;

import java.util.List;

import javax.swing.text.View;

public class GroupViewModel extends ViewModel {

    private MutableLiveData<List<Group>> groups;
    private MutableLiveData<Group> chosenGroup;
    private Context context;

    public GroupViewModel(Context context) {
        this.context = context;
    }

    public void onItemClick(View view) {
        //context.startActivity(GroupFeedActivity.launchWithDetails(view.getContext(), mChosenEvent));
    }

    public MutableLiveData<Group> getChosenGroup() {
        return chosenGroup;
    }

    public MutableLiveData<List<Group>> getGroups() {
        return groups;
    }

    public void setGroupsToSearchResults(String query) { }
    public void setGroupsFilteredByCategory(MutableLiveData<Category> category) {}
    public void setGroupsFilteredBySubcategory(MutableLiveData<Subcategory> subcategory) {}
    public void setGroupsToJoinedGroups(MutableLiveData<User> mCurrentUser) { }
    public void setChosenGroup(MutableLiveData<Group> group) {}




}
