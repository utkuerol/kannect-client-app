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

    private MutableLiveData<List<Group>> groups = new MutableLiveData<>();
    private MutableLiveData<User> currentUser;
    private GroupRepository groupRepository;


    /**
     * initializes the userRepository variable, the groupRepository variable and
     * retrieves the currently logged in user via SharedPreferences and the given context.
     *
     * @param context of the Application.
     */
    public void init(Context context) {
        UserRepository userRepository = new UserRepository();
        groupRepository = new GroupRepository();
        SharedPreferences myPrefs = context.getSharedPreferences("CurrentUser", 0);
        currentUser = userRepository.getUserByID(myPrefs.getInt("CurrentUserId", 0));
    }

    /**
     * method to get the list of Groups.
     * @return list of groups as a MutableLiveData object.
     */
    public MutableLiveData<List<Group>> getGroups() {
        return groups;
    }

    /**
     * method to set the list of groups, so that only groups are in it, that match
     * the given search query.
     * @param query typed in by the user.
     */
    public void setGroupsToSearchResults(String query) {
        groups = groupRepository.getGroups(query);
    }

    /**
     * method to set the list of groups, so that only groups are in it, that are in the given
     * category.
     * @param category chosen by the user.
     */
    public void setGroupsFilteredByCategory(Category category) {
        groups.setValue(category.getGroups());
    }

    /**
     * method to set the list of groups, so that only groups are in it, that are in the given
     * subcategory.
     * @param subcategory chosen by the user.
     */
    public void setGroupsFilteredBySubcategory(Subcategory subcategory) {
        groups.setValue(subcategory.getGroups());
    }

    /**
     * method to set the list of groups, so that only groups are in it, that the currently logged
     * in user is a member in.
     */
    public void setGroupsToJoinedGroups() {
        groups.setValue(currentUser.getValue().getJoinedGroups());
    }

    /**
     * method to get the currently logged in user.
     * @return currently logged in user as a MutableLiveData object.
     */
    public MutableLiveData<User> getCurrentUser() {
        return currentUser;
    }

    /**
     * method to set the currently logged in user.
     * @param currentUser user which will be set as new currently logged in user.
     */
    public void setCurrentUser(MutableLiveData<User> currentUser) {
        this.currentUser = currentUser;
    }
}
