package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.GroupRepository;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;

import java.util.List;


/**
 * ViewModel class for Group, that is responsible for preparing and managing the data for Views,
 * which need a list of Group, by handling the communication of the View with the
 * GroupRepository class, which has the group business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class GroupViewModel extends ViewModel {

    private MutableLiveData<List<Group>> groups;
    private User currentUser;
    private Context context;
    private UserRepository userRepository;
    private GroupRepository groupRepository;


    /**
     * Creates an instance with the given application context.
     *
     * @param context of the application.
     */
    public GroupViewModel(Context context) {
        this.context = context;
        SharedPreferences myPrefs = context.getSharedPreferences("CurrentUser", 0);
        currentUser = userRepository.findUserById(myPrefs.getLong("CurrentUserId", 0));
    }

    public MutableLiveData<List<Group>> getGroups() {
        return groups;
    }

    public void setGroupsToSearchResults(String query) {
        groups = groupRepository.getGroups(query);
    }

    public void setGroupsFilteredByCategory(Category category) {
        groups.setValue(category.getGroups());
    }

    public void setGroupsFilteredBySubcategory(Subcategory subcategory) {
        groups.setValue(subcategory.getGroups());
    }

    public void setGroupsToJoinedGroups(User currentUser) {
        groups.setValue(currentUser.getJoinedGroups());
    }


}
