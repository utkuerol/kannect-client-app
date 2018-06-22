package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;

public class GroupViewModel extends ViewModel {
    Group group ;
    public GroupViewModel() {
    }
    /**
     * constructor
     * @param group: the Group that will be edited.
     */
    public GroupViewModel(Group group) {
        this.group = group;
    }

    /**
     *
     * @return the number of users who have joined this Group.
     */
    public int CountMembers(){
        return 0;
    }

    /**
     * this method shows the list of members, when clicking on the button "Members"
     * in the home page of the Group.
     */
    public void onShowMembersClicked(View view){

    }

    /**
     *This method add a new post to a Group
     * @param view : the view in which the new Post will be added to.
     */
    public void onAddPostClicked(View view){

    }

    /**
     * This method add a User to a Group.
     */
    public void onJoinGroupClicked(User user){

    }

    /**
     *
     * @return the Post when clicking on  it to show all its  details.
     */
    public Post onOpenPostClicked(View view){
        return new Post();
    }

    /**
     * with this method the user edit the information of the Group.
     */
    public void  onEditGroupClicked(View view){

    }
}
