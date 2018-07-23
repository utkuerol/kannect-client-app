package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.EventRepository;
import com.example.asus.example.mvvm.Model.Repository.GroupRepository;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * ViewModel class for one specific subcategory, and is responsible for preparing and managing the data for Views,
 * which need the information of this particular subcategory, by handling the communication of the View with the
 * CategoryRepository class, which has the category and subcategory business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class ItemSubcategoryView extends ViewModel {

    private MutableLiveData<Subcategory> subcategory;
    private User currentUser;
    private Context context;
    private GroupRepository groupRepository;
    private EventRepository eventRepository;


    public void init(Subcategory subcategory) {
        this.subcategory.setValue(subcategory);

        groupRepository = new GroupRepository();
        eventRepository = new EventRepository();

        UserRepository userRepository = new UserRepository();
        SharedPreferences myPrefs = context.getSharedPreferences("CurrentUser", 0);
        currentUser = userRepository.getUserByID(myPrefs.getLong("CurrentUserId", 0)).getValue();
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
     * @param name        of the group to be created.
     * @param description of the group to be created.
     * @param imageUrl    of the group to be created.
     */
    public void createGroup(String name, String description, String imageUrl) {
        Group group = new Group();
        group.setName(name);
        group.setImageURl(imageUrl);
        group.setDescription(description);
        group.setCategory(subcategory.getValue().getCategory());
        group.setCreator(currentUser);
        group.setSubcategory(subcategory.getValue());
        groupRepository.createGroup(group);
    }


    /**
     * Creates a new event in the chosen subcategory with the user-given parameters.
     *
     * @param name        of the event to be created.
     * @param description of the event to be created.
     * @param imageUrl    of the event to be created.
     */

    public void createEvent(String name, String description, String imageUrl, String givenDate)
            throws Exception {

        Event event = new Event();
        Date date = new SimpleDateFormat("dd.mm.yyyy").parse(givenDate);
        event.setCategory(subcategory.getValue().getCategory());
        event.setSubcategory(subcategory.getValue());
        event.setCreator(currentUser);
        event.setDate(date);
        event.setDescription(description);
        event.setName(name);
        event.setImageUrl(imageUrl);
        eventRepository.createEvent(event);
    }

}
