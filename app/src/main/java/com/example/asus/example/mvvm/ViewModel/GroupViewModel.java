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


/**
 * ViewModel class for Group, that is responsible for preparing and managing the data for Views,
 * which need a list of Group, by handling the communication of the View with the
 * GroupRepository class, which has the group business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class GroupViewModel extends ViewModel {

    private MutableLiveData<List<Group>> groups;
    private Context context;

    /**
     * Creates an instance with the given application context.
     *
     * @param context of the application.
     */
    public GroupViewModel(Context context) {
        this.context = context;
    }

    public MutableLiveData<List<Group>> getGroups() {
        return groups;
    }

    public void setGroupsToSearchResults(String query) {
    }

    public void setGroupsFilteredByCategory(Category category) {
    }

    public void setGroupsFilteredBySubcategory(Subcategory subcategory) {
    }

    public void setGroupsToJoinedGroups(User mCurrentUser) {
    }


}
