package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.asus.example.mvvm.Model.Entities.Comment;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.PostRepository;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;
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

    private MutableLiveData<Post> post = new MutableLiveData<>();
    private MutableLiveData<User> currentUser;
    private PostRepository postRepository;


    public void init(Post post, Context context) {
        this.post.setValue(post);
        postRepository = new PostRepository();
        UserRepository userRepository = new UserRepository();

        SharedPreferences myPrefs = context.getSharedPreferences("CurrentUser", 0);
        currentUser = userRepository.getUserByID(myPrefs.getInt("CurrentUserId", 0));
    }


    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get().load(imageUrl)
                .placeholder(android.R.drawable.ic_menu_help)
                .error(android.R.drawable.ic_menu_camera)
                .resize(50, 50)
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
    public void setPost(Post post) {
        this.post.setValue(post);
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
    public String getNumberOfLikes() {
        return Integer.toString(post.getValue().getLikedUsers().size());
    }

    /**
     * method to get the number of user that liked the post.
     *
     * @return number of user that liked the post as a String.
     */
    public String getNumberOfLikesAsString() {
        return Integer.toString(post.getValue().getLikedUsers().size());
    }
    /**
     * Gets the date of creation of the post.
     * @return date of creation
     */
    public Date getDate() {
        return post.getValue().getDate();
    }

    /**
     * gets the date of creation of the post as string.
     * @return date of creation as string
     */
    public String getDateAsString() {
        return post.getValue().getDate().toString();
    }


    public String getOwnerName() {

        if (post.getValue().getOwnerEvent() != null) {
            return post.getValue().getOwnerEvent().getName();
        } else if (post.getValue().getOwnerGroup() != null) {
            return post.getValue().getOwnerGroup().getName();
        } else if (post.getValue().getOwnerUser() != null) {
            return post.getValue().getOwnerUser().getName();
        }

        return null;
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
        postRepository.likePost(post.getValue(), currentUser.getValue());
    }

    /**
     * Unlikes the post.
     */
    public void unlike() {
        postRepository.unlikePost(post.getValue(), currentUser.getValue());
    }

    /**
     * Checks if the current user is the creator of the post.
     *
     * @return boolean
     */
    public boolean isCreator() {
        return post.getValue().getCreator().getId() == currentUser.getValue().getId();
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
        Comment comment = new Comment(text, post.getValue(), new Date(), currentUser.getValue());
        postRepository.commentPost(comment);
    }

    public MutableLiveData<User> getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(MutableLiveData<User> currentUser) {
        this.currentUser = currentUser;
    }

    public void onLike() {
        try {
            like();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void onUnLike() {
        try {
            like();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

