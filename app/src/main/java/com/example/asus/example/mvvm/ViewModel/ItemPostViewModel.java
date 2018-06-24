package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.asus.example.mvvm.Model.Entities.Comment;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;

import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.swing.text.View;

public class ItemPostViewModel extends ViewModel {

    private MutableLiveData<Post> post;
    private Context context;

    public ItemPostViewModel(MutableLiveData<Post> post, Context context) {
        this.post = post;
        this.context = context;
    }

    public MutableLiveData<Post> getPost() {
        return post;
    }

    public void setPost(MutableLiveData<Post> post) {
        this.post = post;
    }

    public void onItemClick(View view) {
        //context.startActivity(GroupFeedActivity.launchWithDetails(view.getContext(), mChosenEvent));
    }


    public String getText() {
    }

    public User getCreator() {
    }

    public String getCreatorName() {}

    public List<User> getLikedUser() {
    }

    public int getNumberOfLikes () {
    }

    public Date getDate() {
    }

    public String getDateAsString() {}

    public Event getBelongsToEvent() {}

    public Group getBelongsToGroup() {
    }

    public User getBelongsToUser() {
    }

    public List<Comment> getComments() {
    }

    public boolean isLiked() {
    }

    public void like() {
    }

    public void unlike() {
    }

    public void deletePost() {
    }

    public void editPost(String text) {
    }

    public void comment(String text) {
    }

}
