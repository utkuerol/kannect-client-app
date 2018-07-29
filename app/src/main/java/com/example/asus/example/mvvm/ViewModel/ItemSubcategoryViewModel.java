package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.Toast;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.EventRepository;
import com.example.asus.example.mvvm.Model.Repository.GroupRepository;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;
import com.example.asus.example.mvvm.View.Navigation_Drawer_Activity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * ViewModel class for one specific subcategory, and is responsible for preparing and managing the data for Views,
 * which need the information of this particular subcategory, by handling the communication of the View with the
 * CategoryRepository class, which has the category and subcategory business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class ItemSubcategoryViewModel extends ViewModel {

    private MutableLiveData<Subcategory> subcategory = new MutableLiveData<>();
    private MutableLiveData<User> currentUser;
    private GroupRepository groupRepository;
    private EventRepository eventRepository;
    private Context context;

    /**
     * Name of the Event/Group which was typed in by the user.
     */
    public final ObservableField<String> inputName = new ObservableField<>("");

    /**
     * Description of the Event/Group, which was typed in by the user.
     */
    public final ObservableField<String> inputDesc = new ObservableField<>("");

    /**
     * Date when the Event will take place. Typed in by user.
     */
    public final ObservableField<String> inputDate = new ObservableField<>("");

    /**
     * Image Url for the Event/Group, Typed in by User.
     */
    public final ObservableField<String> inputImageUrl = new ObservableField<>("");

    /**
     * Initializes all repository Variables. Also sets the subcategory.
     * Retrieves the currently logged in user from storage via SharedPreferences and the
     * UserViewModel.
     *
     * @param subcategory which will be handled in this class.
     * @param context     of the Application.
     */
    public void init(Subcategory subcategory, Context context) {
        this.subcategory.setValue(subcategory);
        this.context = context;
        groupRepository = new GroupRepository();
        eventRepository = new EventRepository();

        UserRepository userRepository = new UserRepository();
        SharedPreferences myPrefs = context.getSharedPreferences("CurrentUser", 0);
        currentUser = userRepository.getUserByID(myPrefs.getInt("CurrentUserId", 0));
    }

    /**
     * sets the subcategory
     * @param subcategory which will be set.
     */
    public void setSubcategory(Subcategory subcategory) {
        this.subcategory.setValue(subcategory);
    }


    /**
     * Starts the SubcategoryEventPageActivity with the chosen subcategory.
     *
     * @param view
     */
    public void onItemClickEvent(View view) {

    }

    /**
     * Starts the SubcategoryGroupPageActivity with the chosen subcategory.
     *
     * @param view
     */
    public void onItemClickGroup(View view) {

    }

    /**
     * Gets the name of the subcategory.
     * @return name of the Subcategory as a String.
     */
    public String getName() {
        return subcategory.getValue().getName();
    }

    /**
     * Creates a new group in the chosen subcategory with the user-given parameters.
     *
     *
     */
    public void createGroup(View view) {
        if (!isFalseInput()) {
            Group group = new Group();
            group.setName(inputName.get());
            group.setImageURl(inputImageUrl.get());
            group.setDescription(inputDesc.get());
            group.setCategory(subcategory.getValue().getCategory());
            group.setCreator(currentUser.getValue());
            group.setSubcategory(subcategory.getValue());
            groupRepository.createGroup(group);

            Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) view.getContext();
            navigation_drawer_activity.launchGroupFeedFragment(group);
        } else {
            Toast.makeText(context, "Es müssen alle Felder ausgefüllt sein!", Toast.LENGTH_LONG).show();
        }

    }


    /**
     * Creates a new event in the chosen subcategory with the user-given parameters.
     *
     */

    public void createEvent(View view)
            throws Exception {

        Event event = new Event();
        Date date = new SimpleDateFormat("dd.mm.yyyy").parse(inputDate.get());
        event.setCategory(subcategory.getValue().getCategory());
        event.setSubcategory(subcategory.getValue());
        event.setCreator(currentUser.getValue());
        event.setDate(date);
        event.setDescription(inputDesc.get());
        event.setName(inputName.get());
        event.setImageUrl(inputImageUrl.get());
        eventRepository.createEvent(event);

        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) view.getContext();
        navigation_drawer_activity.launchEventFeedFragment(event);
    }

    /**
     * method to get the currently logged in user.
     * @return logged in user as a MutableliveData object.
     */
    public MutableLiveData<User> getCurrentUser() {
        return currentUser;
    }

    /**
     * sets the currently logged in user.
     * @param currentUser user which will be set.
     */
    public void setCurrentUser(MutableLiveData<User> currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * method which handles the click on the create Event Button.
     * checks if the user Input is valid.
     */
    public void onCreateEventClick(View view) {
        if (!isFalseInput() && dateIsValidFormat()) {
            try {
                createEvent(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(context, "Es müssen alle Felder richtig ausgefüllt sein!", Toast.LENGTH_LONG).show();
        }
    }


    private boolean isFalseInput() {
        return (inputDesc.get().length() == 0 || inputName.get().length() == 0);
    }


    private boolean dateIsValidFormat() {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            date = sdf.parse(inputDate.get());
            if (!inputDate.get().equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }
}
