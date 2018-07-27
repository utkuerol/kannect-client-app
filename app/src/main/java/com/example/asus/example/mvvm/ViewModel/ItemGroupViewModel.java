package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.FeedRepository;
import com.example.asus.example.mvvm.Model.Repository.GroupRepository;
import com.example.asus.example.mvvm.Model.Repository.PostRepository;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;


/**
 * ViewModel class for one specific group, and is responsible for preparing and managing the data for Views,
 * which need the information of this particular group, by handling the communication of the View with the
 * GroupRepository class, which has the group business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class ItemGroupViewModel extends ViewModel {

    private MutableLiveData<Group> chosenGroup = new MutableLiveData<>();
    private MutableLiveData<User> currentUser;
    private GroupRepository groupRepository;
    private FeedRepository feedRepository;
    private PostRepository postRepository;


    public final ObservableField<String> inputName = new ObservableField<>("");
    public final ObservableField<String> inputDesc = new ObservableField<>("");
    public final ObservableField<String> inputImageUrl = new ObservableField<>("");
    public final ObservableField<String> textValue = new ObservableField<>("");


    public void init(Group chosenGroup, Context context) {
        this.chosenGroup.setValue(chosenGroup);
        postRepository = new PostRepository();
        UserRepository userRepository = new UserRepository();
        feedRepository = new FeedRepository();
        groupRepository = new GroupRepository();

        SharedPreferences myPrefs = context.getSharedPreferences("CurrentUser", 0);
        currentUser = userRepository.getUserByID(myPrefs.getInt("CurrentUserId", 0));
    }



    /**
     * Gets chosenGroup.
     * @return observable group.
     */
    public MutableLiveData<Group> getChosenGroup() {
        return chosenGroup;
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
     * Sets the chosenGroup.
     * @param group to set.
     */
    public void setChosenGroup(Group group) {
        this.chosenGroup.setValue(group);
    }

    /**
     * Gets the name of the group.
     * @return name
     */
    public String getName() {

        return chosenGroup.getValue().getName();
    }


    /**
     * Gets the description of the group.
     * @return description
     */
    public String getDescription() {

        return chosenGroup.getValue().getDescription();
    }

    /**
     * method to get the User, who created the Group.
     * @return Creator of the Group.
     */
    public User getCreator() {
        return chosenGroup.getValue().getCreator();
    }

    /**
     * method to get the creator of a group as String
     *
     * @return creator as string
     */
    public String getCreatorAsString() {
        return chosenGroup.getValue().getCreator().toString();
    }
    /**
     * method to get The Category this Group belongs to.
     * @return Category this Group belongs to.
     */
    public Category getCategory() {
        return chosenGroup.getValue().getCategory();
    }

    /**
     * method to get the Subcategory this Group belongs to.
     * @return Subcategory this Group belongs to.
     */
    public Subcategory getSubcategory() {
        return chosenGroup.getValue().getSubcategory();
    }

    /**
     * method to get the imageUrl of the profile picture of this Group
     * @return the imageUrl of this Group
     */
    public String getImageURl() {
        return chosenGroup.getValue().getImageURl();
    }

    /**
     * method to get the numberOfMembers as a string
     *
     * @return number of members as string
     */
    public String getNumberOfMembersAsString() {
        return Integer.toString(chosenGroup.getValue().getMembers().size());
    }
    /**
     * method to get the List of Users who joined the Group
     * @return List of Members
     */
    public List<User> getMembers() {
        return chosenGroup.getValue().getMembers();
    }

    /**
     * Checks if the current user is the creator of the group.
     * @return boolean result
     */
    public boolean isCreator() {
        return chosenGroup.getValue().getCreator().getId() == currentUser.getValue().getId();
    }


    /**
     * Checks if the current user has joined the group
     * @return boolean result
     */
    public boolean joinedThisGroup() {
        return chosenGroup.getValue().getMembers().contains(currentUser);
    }

    public List<Post> getGroupFeed() {

        return feedRepository.getGroupFeed(chosenGroup.getValue()).getValue();
    }

    /**
     * Joins the group.
     */
    public void joinGroup() {
        groupRepository.joinGroup(currentUser.getValue(), chosenGroup.getValue());
    }

    /**
     * Leaves the group
     */
    public void leaveGroup() {
        groupRepository.leaveGroup(currentUser.getValue(), chosenGroup.getValue());
    }


    /**
     * Deletes the group
     */
    public void deleteGroup() {
        groupRepository.deleteGroup(chosenGroup.getValue());
    }

    /**
     * Creates post in the group with the given text.
     *
     */
    public void createPost() {
        Post post = new Post();
        post.setDate(new Date());
        post.setText(textValue.get());
        post.setCreator(currentUser.getValue());
        post.setOwnedBy(chosenGroup.getValue().getId());
        post.setOwnerGroup(chosenGroup.getValue());
        postRepository.createPost(post);
    }

    public void createGroup() throws Exception {
        Group group = new Group();
        //group.setCategory(chosenCategory.getValue());
        group.setCreator(currentUser.getValue());
        group.setDescription(inputDesc.get());
        group.setName(inputName.get());
        group.setImageURl(inputImageUrl.get());
        groupRepository.createGroup(group);
    }

    public MutableLiveData<User> getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(MutableLiveData<User> currentUser) {
        this.currentUser = currentUser;
    }

    public void onCreateGroupClick() {
        try {
            createGroup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onCreatePostClick() {
        try {
            createPost();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
