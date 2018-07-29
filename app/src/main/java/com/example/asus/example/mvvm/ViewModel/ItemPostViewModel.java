package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.example.asus.example.mvvm.Model.Entities.Comment;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.EventRepository;
import com.example.asus.example.mvvm.Model.Repository.GroupRepository;
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
    private UserRepository userRepository;
    private EventRepository eventRepository;
    private GroupRepository groupRepository;


    /**
     * loads a given image into a view via an url.
     *
     * @param view     in which the image will be loaded
     * @param imageUrl of the image which will be loaded.
     */
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get().load(imageUrl)
                .placeholder(android.R.drawable.ic_menu_help)
                .error(android.R.drawable.ic_menu_camera)
                .resize(50, 50)
                .into(view);
    }

    /**
     * initializes repository Variables, and sets the value of post to given post.
     * Retrieves currently logged in user from storage via SharedPreferences and the
     * UserRepository.
     *
     * @param post    which will be handled in this class.
     * @param context of the Application.
     */
    public void init(Post post, Context context) {
        this.post.setValue(post);
        postRepository = new PostRepository();
        userRepository = new UserRepository();
        eventRepository = new EventRepository();
        groupRepository = new GroupRepository();

        SharedPreferences myPrefs = context.getSharedPreferences("CurrentUser", 0);
        currentUser = userRepository.getUserByID(myPrefs.getInt("CurrentUserId", 0));
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

    /**
     * method to get the name of the owner of the post. Meaning the entity it belongs to.
     * @return name of the owner.
     */
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

    /**
     * method to get the currently logged in user.
     * @return logged in user as a MutableLiveData object.
     */
    public MutableLiveData<User> getCurrentUser() {
        return currentUser;
    }

    /**
     * sets the currently logged in user.
     * @param currentUser user which us currently logged in.
     */
    public void setCurrentUser(MutableLiveData<User> currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * method which handles the actions, when a user likes a post.
     */
    public void onLike(View v) {
        try {
            like();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * method which handles the actions, when a user unlikes a post.
     */
    public void onUnLike(View v) {
        try {
            unlike();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MutableLiveData<User> getOwnerUser() {
        return userRepository.getUserByID(this.post.getValue().getOwnedBy());
    }

    public MutableLiveData<Event> getOwnerEvent() {
        return eventRepository.getEventById(this.post.getValue().getOwnedBy());
    }

    public MutableLiveData<Group> getOwnerGroup() {
        return groupRepository.getGroupById(this.post.getValue().getOwnedBy());
    }
}

