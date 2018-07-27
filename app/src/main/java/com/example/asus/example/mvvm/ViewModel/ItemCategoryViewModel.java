package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.ObservableField;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.EventRepository;
import com.example.asus.example.mvvm.Model.Repository.GroupRepository;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * ViewModel class for one specific category, and is responsible for preparing and managing the data for Views,
 * which need the information of this particular category, by handling the communication of the View with the
 * CategoryRepository class, which has the category business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class ItemCategoryViewModel extends ViewModel {

    private MutableLiveData<Category> chosenCategory = new MutableLiveData<>();
    private MutableLiveData<User> currentUser;

    private GroupRepository groupRepository;
    private EventRepository eventRepository;

    /**
     * name for the group/event. Typed in by User.
     */
    public final ObservableField<String> inputName = new ObservableField<>("");

    /**
     * description for the group/event. Typed in by user.
     */
    public final ObservableField<String>  inputDesc = new ObservableField<>("");

    /**
     * Date for the Event. Typed in by user.
     */
    public final ObservableField<String> inputDate = new ObservableField<>("");

    /**
     * Image Url for the event/group. Typed in by User.
     */
    public final ObservableField<String> inputImageUrl = new ObservableField<>("");


    /**
     * initializes userRepository variable, groupRepository variable and eventRepository variable.
     * Also sets the chosenCategory by the given Category.
     * Retrieves the currently logged in User id from storage using SharedPreferences and the given
     * Context and looks for the user object in the server.
     *
     * @param chosenCategory Category which the user clicked on.
     * @param context        of the Application.
     */
    public void init(Category chosenCategory, Context context) {
        this.chosenCategory.setValue(chosenCategory);
        UserRepository userRepository = new UserRepository();
        groupRepository = new GroupRepository();
        eventRepository = new EventRepository();

        SharedPreferences myPrefs = context.getSharedPreferences("CurrentUser", 0);
        currentUser = userRepository.getUserByID(myPrefs.getInt("CurrentUserId", 0));
    }


    /**
     * Gets the chosen category.
     * @return observable category.
     */
    public MutableLiveData<Category> getChosenCategory() {
        return chosenCategory;
    }

    /**
     * Sets the chosen category.
     * @param chosenCategory to set.
     */
    public void setChosenCategory(Category chosenCategory) {
        this.chosenCategory.setValue(chosenCategory);
    }

    /**
     * method to get the currently logged in user.
     * @return user as a MutableLiveData object.
     */
    public MutableLiveData<User> getCurrentUser() {
        return currentUser;
    }

    /**
     * sets the currently logged in user.
     * @param currentUser new currently logged in user, as a MutableLiveData object.
     */
    public void setCurrentUser(MutableLiveData<User> currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * Gets list of subcategories of the category.
     * @return list of subcategories.
     */
    public List<Subcategory> getSubcategories() {
        return chosenCategory.getValue().getSubcategories();
    }

    /**
     * Gets the name of the category
     * @return name of the category
     */
    public String getName() {
        return chosenCategory.getValue().getName();
    }



    /**
     * Creates a new group in the chosen category.
     *
     */
    public void createGroup() {
        Group group = new Group();
        group.setCategory(chosenCategory.getValue());
        group.setCreator(currentUser.getValue());
        group.setDescription(inputDesc.get());
        group.setImageURl(inputImageUrl.get());
        group.setName(inputName.get());
        groupRepository.createGroup(group);
    }

    /**
     * Creates a new event in the chosen category.
     */
    public void createEvent() throws Exception {
        Event event = new Event();
        Date date = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY).parse(inputDate.get());
        event.setCategory(chosenCategory.getValue());
        event.setCreator(currentUser.getValue());
        event.setDate(date);
        event.setDescription(inputDesc.get());
        event.setName(inputName.get());
        event.setImageUrl(inputImageUrl.get());
        eventRepository.createEvent(event);
    }

    /**
     * method which will be called, when the user presses the Button to create an Event.
     */
    public void onCreateEventClick() {
        try {
            createEvent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Method which will be called, when the user presses the Button to create a Group.
     */
    public void onCreateGroupClick() {
        try {
            createGroup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
