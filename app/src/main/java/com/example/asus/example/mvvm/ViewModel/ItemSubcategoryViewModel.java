package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.ObservableField;
import android.view.View;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.EventRepository;
import com.example.asus.example.mvvm.Model.Repository.GroupRepository;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;

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


    public final ObservableField<String> inputName = new ObservableField<>("");
    public final ObservableField<String> inputDesc = new ObservableField<>("");
    public final ObservableField<String> inputDate = new ObservableField<>("");
    public final ObservableField<String> inputImageUrl = new ObservableField<>("");

    public void init(Subcategory subcategory, Context context) {
        this.subcategory.setValue(subcategory);

        groupRepository = new GroupRepository();
        eventRepository = new EventRepository();

        UserRepository userRepository = new UserRepository();
        SharedPreferences myPrefs = context.getSharedPreferences("CurrentUser", 0);
        currentUser = userRepository.getUserByID(myPrefs.getInt("CurrentUserId", 0));
    }

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
     *
     * @return
     */
    public String getName() {
        return subcategory.getValue().getName();
    }

    /**
     * Creates a new group in the chosen subcategory with the user-given parameters.
     *
     *
     */
    public void createGroup() {
        Group group = new Group();
        group.setName(inputName.get());
        group.setImageURl(inputImageUrl.get());
        group.setDescription(inputDesc.get());
        group.setCategory(subcategory.getValue().getCategory());
        group.setCreator(currentUser.getValue());
        group.setSubcategory(subcategory.getValue());
        groupRepository.createGroup(group);
    }


    /**
     * Creates a new event in the chosen subcategory with the user-given parameters.
     *
     */

    public void createEvent()
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
    }

    public MutableLiveData<User> getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(MutableLiveData<User> currentUser) {
        this.currentUser = currentUser;
    }

    public void onCreateEventClick() {
        if (!checkIfInputIsFalse() && dateIsValidFormat()) {
            try {
                createEvent();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onCreateGroupClick() {

        if (!checkIfInputIsFalse()) {
            try {
                createGroup();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean checkIfInputIsFalse() {
        if (inputDesc.get().length() == 0) {
            return true;
        } else if (inputImageUrl.get().length() == 0) {
            return true;
        } else if (inputName.get().length() == 0) {
            return true;
        }
        return false;
    }

    private boolean dateIsValidFormat() {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            date = sdf.parse(inputDate.get());
            if (!inputName.get().equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }
}
