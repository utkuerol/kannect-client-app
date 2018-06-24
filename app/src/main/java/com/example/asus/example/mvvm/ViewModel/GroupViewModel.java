package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Repository.GroupRepository;

import java.util.List;

/**
 * ViewModel class for Groups, that is responsible for preparing and managing the data for Views,
 * which need a list of groups, by handling the communication of the View with the
 * GroupRepository class, which has the group business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class GroupViewModel extends ViewModel {

    private MutableLiveData<List<Group>> groups;
    private Context context;
    private GroupRepository groupRepository;

    /**
     * Creates an instance with the given application context.
     *
     * @param context of the application.
     */
    public GroupViewModel(Context context) {
        this.context = context;
    }

    /**
     * Gets the list of groups.
     * @return observable list of groups.
     */
    public MutableLiveData<List<Group>> getGroups() {
        return groups;
    }

    /**
     * Sets the groups to search results of the given query.
     * @param query to search.
     */
    public void setGroupsToSearchResults(String query) {
    }

    /**
     * Sets the groups with all groups of the given category.
     * @param category to filter
     */
    public void setGroupsFilteredByCategory(MutableLiveData<Category> category) {
    }

    /**
     * Sets the groups with all groups of the given subcategory.
     * @param subcategory to filter.
     */
    public void setGroupsFilteredBySubcategory(MutableLiveData<Subcategory> subcategory) {
    }

    /**
     * Sets the groups to current user's list of joined groups.
     */
    public void setGroupsToJoinedGroups() { }




}
