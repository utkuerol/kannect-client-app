package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.example.asus.example.mvvm.Model.Entities.Comment;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.PostRepository;
import com.example.asus.example.mvvm.View.ShowPostActivity;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

/**
 * ViewModel class for one specific post, and is responsible for preparing and managing the data for Views,
 * which need the information of this particular post, by handling the communication of the View with the
 * PostRepository class, which has the post business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class ItemPostViewModel extends ViewModel {

    private MutableLiveData<Post> post;
    private String creatorProfilePictureUrl;
    private Context context;
    private User currentUser;
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
        creatorProfilePictureUrl = this.getCreator().getImageUrl();
    }

    @BindingAdapter({"bind:creatorProfilePictureUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get().load(imageUrl)
                //  .placeholder(R.drawable.placeholder)
                .into(view);
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
        context.startActivity(ShowPostActivity.launchWithDetails(view.getContext(), post.getValue()));
    }

    /**
     * Gets text of the post.
     * @return
     */
    public String getText() {
        return post.getValue().getText();
    }

    /**
     * Gets the creator user of the post.
     * @return user
     */
    public User getCreator() {
        return post.getValue().getCreator();
    }

    /**
     * Gets the creator name of the post.
     * @return user's name
     */
    public String getCreatorName() {
        return post.getValue().getCreator().getName();
    }

    /**
     * Gets the list of liked users of the post.
     * @return list of users
     */
    public List<User> getLikedUsers() {
        return post.getValue().getLikedUsers();
    }

    /**
     * Gets the number of likes of the post.
     * @return number of likes
     */
    public int getNumberOfLikes () {
        return post.getValue().getLikedUsers().size();
    }

    /**
     * Gets the date of creation of the post.
     * @return date of creation
     */
    public Date getDate() {
        return post.getValue().getDate();
    }

    public void setDate(Date d) {
        post.getValue().setDate(d);
    }

    /**
     * gets the date of creation of the post as string.
     * @return date of creation as string
     */
    public String getDateAsString() {
        return post.getValue().getDate().toString();
    }

    /**
     * Gets the event to which the post belongs.
     * @return event
     */
    public Event getBelongsToEvent() {
        return post.getValue().getBelongsToEvent();
    }

    /**
     * Gets the group to which the post belongs.
     * @return group
     */
    public Group getBelongsToGroup() {
        return post.getValue().getBelongsToGroup();
    }

    /**
     * Gets the user to which the post belongs.
     * @return user
     */
    public User getBelongsToUser() {
        return post.getValue().getBelongsToUser();
    }

    /**
     * Gets the comments belonging to the post.
     * @return list of comments
     */
    public List<Comment> getComments() {
        return post.getValue().getComments();
    }

    /**
     * Checks if the current user has already liked this post.
     * @return
     */
    public boolean isLiked() {
        return post.getValue().getLikedUsers().contains(currentUser);
    }

    /**
     * Likes the post.
     */
    public void like() {
        postRepository.likePost(post.getValue(), currentUser);
    }

    /**
     *
     */
    public void unlike() {
        postRepository.unlikePost(post.getValue(), currentUser);
    }

    /**
     * Checks if the current user is the creator of the post.
     *
     * @return boolean
     */
    public boolean isCreator() {
        return post.getValue().getCreator().getId() == currentUser.getId();
    }

    /**
     * Deletes the post.
     */
    public void deletePost() {
        postRepository.deletePost(post.getValue());
    }


    /**
     * Creates a new comment for the post with the given text.
     * @param text for the comment to be created.
     */
    public void comment(String text) {
        Comment comment = new Comment(text, post.getValue(), new Date(), currentUser);
        postRepository.commentPost(comment);
    }

}
