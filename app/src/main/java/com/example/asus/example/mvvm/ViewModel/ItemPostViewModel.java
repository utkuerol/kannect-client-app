package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.view.View;

import com.example.asus.example.mvvm.Model.Entities.Comment;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.PostRepository;

import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.swing.text.View;

/**
 * ViewModel class for one specific post, and is responsible for preparing and managing the data for Views,
 * which need the information of this particular post, by handling the communication of the View with the
 * PostRepository class, which has the post business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class ItemPostViewModel extends ViewModel {

    private MutableLiveData<Post> post;
    private Context context;
    private PostRepository postRepository;

    /**
     * Creates an instance with the given post and application context.
     *
     * @param post    to be displayed.
     * @param context of the application.
     */
    public ItemPostViewModel(MutableLiveData<Post> post, Context context) {
        this.post = post;
        this.context = context;
    }

    /**
     * Gets the post.
     * @return observable post object.
     */
    public MutableLiveData<Post> getPost() {
        return post;
    }

    /**
     * Sets the post.
     * @param post to be set.
     */
    public void setPost(MutableLiveData<Post> post) {
        this.post = post;
    }

    /**
     * Starts CommentsActivity with this post.
     * @param view
     */
    public void onItemClick(View view) {
        //context.startActivity(GroupFeedActivity.launchWithDetails(view.getContext(), mChosenEvent));
    }

    /**
     * Gets text of the post.
     * @return
     */
    public String getText() {
    }

    /**
     * Gets the creator user of the post.
     * @return user
     */
    public User getCreator() {
    }

    /**
     * Gets the creator name of the post.
     * @return user's name
     */
    public String getCreatorName() {
    }

    /**
     * Gets the list of liked users of the post.
     * @return list of users
     */
    public List<User> getLikedUser() {
    }

    /**
     * Gets the number of likes of the post.
     * @return number of likes
     */
    public int getNumberOfLikes () {
    }

    /**
     * Gets the date of creation of the post.
     * @return date of creation
     */
    public Date getDate() {
    }

    /**
     * gets the date of creation of the post as string.
     * @return date of creation as string
     */
    public String getDateAsString() {
    }

    /**
     * Gets the event to which the post belongs.
     * @return event
     */
    public Event getBelongsToEvent() {
    }

    /**
     * Gets the group to which the post belongs.
     * @return group
     */
    public Group getBelongsToGroup() {
    }

    /**
     * Gets the user to which the post belongs.
     * @return user
     */
    public User getBelongsToUser() {
    }

    /**
     * Gets the comments belonging to the post.
     * @return list of comments
     */
    public List<Comment> getComments() {
    }

    /**
     * Checks if the current user has already liked this post.
     * @return
     */
    public boolean isLiked() {
    }

    /**
     * Likes the post.
     */
    public void like() {
    }

    /**
     * Unlikes the post.
     */
    public void unlike() {
    }

    /**
     * Checks if the current user is the creator of the post.
     *
     * @return boolean
     */
    public boolean isCreator() {
    }

    /**
     * Deletes the post.
     */
    public void deletePost() {
    }

    /**
     * Edits the post with the given text.
     * @param text to edit.
     */
    public void editPost(String text) {
    }

    /**
     * Creates a new comment for the post with the given text.
     * @param text for the comment to be created.
     */
    public void comment(String text) {
    }

}
