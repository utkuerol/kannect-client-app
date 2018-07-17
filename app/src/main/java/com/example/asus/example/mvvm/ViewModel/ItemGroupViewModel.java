package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.GroupRepository;

import java.util.List;

import javax.swing.text.View;

/**
 * ViewModel class for one specific group, and is responsible for preparing and managing the data for Views,
 * which need the information of this particular group, by handling the communication of the View with the
 * GroupRepository class, which has the group business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class ItemGroupViewModel extends ViewModel {

    private MutableLiveData<Group> chosenGroup;
    private Context context;
    private GroupRepository groupRepository;

    /**
     * Creates an instance with the chosenGroup and application context.
     *
     * @param chosenGroup
     * @param context     of the application
     */
    public ItemGroupViewModel(MutableLiveData<Group> chosenGroup, Context context) {
        this.chosenGroup = chosenGroup;
        this.context = context;
    }


    /**
     * Starts the GroupFeedActivity with the chosenGroup.
     * @param view
     */
    public void onItemClick(View view) {
        //context.startActivity(GroupFeedActivity.launchWithDetails(view.getContext(), mChosenEvent));
    }

    /**
     * Gets chosenGroup.
     * @return observable group.
     */
    public MutableLiveData<Group> getChosenGroup() {
        return chosenGroup;
    }

    /**
     * Sets the chosenGroup.
     * @param group to set.
     */
    public void setChosenGroup(MutableLiveData<Group> group) {
    }


    /**
     * Gets the name of the group.
     * @return name
     */
    public String getName() {
    }

    /**
     * Gets the description of the group.
     * @return description
     */
    public String getDescription() {
    }

    /**
     * method to get the User, who created the Group.
     * @return Creator of the Group.
     */
    public User getCreator() {
        return creator;
    }

    /**
     * method to get The Category this Group belongs to.
     * @return Category this Group belongs to.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * method to get the Subcategory this Group belongs to.
     * @return Subcategory this Group belongs to.
     */
    public Subcategory getSubcategory() {
        return subcategory;
    }

    /**
     * method to get the imageUrl of the profile picture of this Group
     * @return the imageUrl of this Group
     */
    public String getImageURl() {
        return imageURl;
    }

    /**
     * method to get the List of Users who joined the Group
     * @return List of Members
     */
    public List<User> getMembers() {
        return members;
    }

    /**
     * Checks if the current user is the creator of the group.
     * @return boolean result
     */
    public boolean isCreator() {
    }

    /**
     * sets the User who created the Group.
     *
     * @param creator Creator of the Group.
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }

    /**
     * Checks if the current user has joined the group
     * @return boolean result
     */
    public boolean joinedThisGroup() {
    }

    /**
     * Joins the group.
     */
    public void joinGroup() {
    }

    /**
     * Leaves the group
     */
    public void leaveGroup() {
    }

    /**
     * Edits the group with given parameters.
     * @param newName to set.
     * @param newDescription to set.
     */
    public void editGroup(String newName, String newDescription) {
    }

    /**
     * Deletes the group
     */
    public void deleteGroup() {
    }

    /**
     * Creates post in the group with the given text.
     * @param text for the post.
     */
    public void createPost(String text) {
    }


}
