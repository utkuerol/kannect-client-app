package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.EventRepository;
import com.example.asus.example.mvvm.Model.Repository.FeedRepository;
import com.example.asus.example.mvvm.Model.Repository.PostRepository;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;


/**
 * ViewModel class for one specific event, and is responsible for preparing and managing the data for Views,
 * which need the information of this particular event, by handling the communication of the View with the
 * EventRepository class, which has the group business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class ItemEventViewModel extends ViewModel {

    private MutableLiveData<Event> event = new MutableLiveData<>();
    private MutableLiveData<List<Post>> mEventFeed = new MutableLiveData<>();

    /**
     * Text of the Post, the user typed in.
     */
    public final ObservableField<String> textValue = new ObservableField<>("");


    private MutableLiveData<User> currentUser;
    private EventRepository eventRepository;
    private FeedRepository feedRepository;
    private PostRepository postRepository;

    /**
     * method to draw a picture on the screen.
     *
     * @param view     on which the picture will be drawn upon.
     * @param imageUrl url of the image that will be drawn.
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
     * Gets the event
     * @return observable event.
     */
    public MutableLiveData<Event> getEvent() {
        return event;
    }

    /**
     * Sets the event
     * @param event to set to.
     */
    public void setEvent(MutableLiveData<Event> event) {

        this.event = event;
    }


    /**
     * method to get the Name of the Event.
     * @return name of the Event.
     */
    public String getName() {
        return event.getValue().getName();
    }


    /**
     * method to get the Date, on which the Event will take place.
     * @return the Date on which the Event will take place.
     */
    public Date getDate() {
        return event.getValue().getDate();
    }

    /**
     * @return date as string
     */
    public String getDateAsString() {
        return event.getValue().getDate().toString();
    }


    /**
     * method to get the description of the Event.
     * @return description of the Event.
     */
    public String getDescription() {
        return event.getValue().getDescription();
    }

    /**
     * method to get the user who created the Event.
     * @return the Creator of the Event.
     */
    public User getCreator() {
        return event.getValue().getCreator();
    }


    /**
     * method to get the Category this Event belongs to.
     * @return the Category this Events belongs to.
     */
    public Category getCategory() {
        return event.getValue().getCategory();
    }

    /**
     * method to get the Subcategory this Event belongs to.
     * @return the Subcategory this Event belongs to.
     */
    public Subcategory getSubcategory() {
        return event.getValue().getSubcategory();
    }


    /**
     * method to get the imageUrl of the profile picture of the Event.
     * @return the imageUrl of the profile picture.
     */
    public String getImageUrl() {
        return event.getValue().getImageUrl();
    }

    /**
     * initializes following variables: postRepository, feedRepository, eventRepository. Also
     * creates an UserRepository object.
     * Sets the event, which was given.
     * Retrieves the currently logged in UserId from storage via SharedPreferences and get the
     * user object which matched the id from the server.
     *
     * @param event   which the user clicked on.
     * @param context of the Application.
     */
    public void init(Event event, Context context) {
        this.event.setValue(event);
        postRepository = new PostRepository();
        UserRepository userRepository = new UserRepository();
        feedRepository = new FeedRepository();
        eventRepository = new EventRepository();

        SharedPreferences myPrefs = context.getSharedPreferences("CurrentUser", 0);
        currentUser = userRepository.getUserByID(myPrefs.getInt("CurrentUserId", 0));
    }

    /**
     * method to get the List of User who want to participate in this Event.
     * @return List of Participants
     */
    public List<User> getParticipants() {
        return event.getValue().getParticipants();
    }

    /**
     * method to get the Number of participants of this event
     * @return number of participants of this event as a string.
     */
    public String getNumberOfParticipants() {
        return Integer.toString(getParticipants().size());
    }

    /**
     * Gets the feed of the event.
     * @return list of posts.
     */
    public MutableLiveData<List<Post>> getEventFeed() {
        return feedRepository.getEventFeed(event.getValue());
    }

    /**
     * Checks if the current user is the creator of the event
     * @return boolean result
     */
    public boolean isCreator() {
        return event.getValue().getCreator().getId() == currentUser.getValue().getId();
    }

    /**
     * checks if the current user is participating in this event.
     * @return boolean result
     */
    public boolean participatingThisEvent() {
        return event.getValue().getParticipants().contains(currentUser);
    }


    /**
     * Participates in the event.
     */
    public void participateEvent() {
        eventRepository.participateEvent(currentUser.getValue(), event.getValue());
    }

    /**
     * Leaves the event
     */
    public void leaveEvent() {
        eventRepository.leaveEvent(currentUser.getValue(), event.getValue());
    }


    /**
     * Deletes the event.
     */
    public void deleteEvent() {
        eventRepository.deleteEvent(event.getValue());
    }

    /**
     * Creates a post owned by this event.
     *
     */
    public void createPost() {
        Post post = new Post();
        post.setCreator(currentUser.getValue());
        post.setText(textValue.get());
        post.setOwnedBy(event.getValue().getId());
        post.setOwnerEvent(event.getValue());
        post.setDate(new Date());
        postRepository.createPost(post);
    }

    /**
     * method to get the currently logged in user.
     * @return logged in user as a MutableLiveData object.
     */
    public MutableLiveData<User> getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(MutableLiveData<User> currentUser) {
        this.currentUser = currentUser;
    }


    public void onCreateEventClick() {
        try {
            createPost();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * method which will be called when the user presses the createPost icon.
     * Creates a Post for the Event.
     */
    public void onCreatePostClick() {
        try {
            createPost();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
