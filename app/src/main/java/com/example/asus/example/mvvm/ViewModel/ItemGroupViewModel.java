package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;

import java.util.List;

import javax.swing.text.View;

/**
 * ViewModel class for itemGroup, that is responsible for preparing and managing the data for Views,
 * which need a list of itemGroup, by handling the communication of the View with the
 * Recyclerview element.
 */
public class ItemGroupViewModel extends ViewModel {

    private MutableLiveData<Group> chosenGroup;
    private Context context;

    /**
     * Creates an instance with the given application context.
     *
     * @param context of the application.
     */
    public ItemGroupViewModel(Group chosenGroup, Context context) {
        MutableLiveData<Group> ch = new MutableLiveData<Group>();
        ch.setValue(chosenGroup);
        this.chosenGroup = ch;
        this.context = context;
    }


    /**
     * method will be invoked by clicking on the item
     *
     * @param view the current View
     */
    public void onItemClick(View view) {
        //context.startActivity(GroupFeedActivity.launchWithDetails(view.getContext(), mChosenEvent));
    }

    public Group getChosenGroup() {
        return chosenGroup.getValue();
    }

    public void setChosenGroup(Group group) {
    }


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

    public List<Post> getGroupFeed() {
    }

    public boolean isCreator() {
    }

    public boolean joinedThisGroup() {
    }


    public void joinGroup() {
    }


    public void leaveGroup() {
    }

    public void editGroup(String newName, String newDescription) {
    }

    public void deleteGroup() {
    }

    public void createPost(String text) {
    }


}
