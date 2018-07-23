package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.SharedPreferences;

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

/**
 * ViewModel class for one specific category, and is responsible for preparing and managing the data for Views,
 * which need the information of this particular category, by handling the communication of the View with the
 * CategoryRepository class, which has the category business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class ItemCategoryViewModel extends ViewModel {

    private MutableLiveData<Category> chosenCategory;
    private User currentUser;
    private Context context;

    private GroupRepository groupRepository;
    private EventRepository eventRepository;

    /**
     * Creates an instance with the chosenCategory and the application context.
     *
     * @param chosenCategory to set
     * @param context        of the application.
     */
    public ItemCategoryViewModel(MutableLiveData<Category> chosenCategory, Context context) {
        this.chosenCategory = chosenCategory;
        this.context = context;
        UserRepository userRepository = new UserRepository();
        groupRepository = new GroupRepository();
        eventRepository = new EventRepository();

        SharedPreferences myPrefs = context.getSharedPreferences("CurrentUser", 0);
        currentUser = userRepository.getUserByID(myPrefs.getLong("CurrentUserId", 0)).getValue();
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
     * @param name of the group to be created
     * @param description of the group to be created
     * @param imageUrl of the group to be created
     */
    public void createGroup(String name, String description, String imageUrl) {
        Group group = new Group();
        group.setCategory(chosenCategory.getValue());
        group.setCreator(currentUser);
        group.setDescription(description);
        group.setImageURl(imageUrl);
        group.setName(name);
        groupRepository.createGroup(group);
    }

    /**
     * Creates a new event in the chosen category.
     * @param name of the event to be created
     * @param description of the event to be created
     * @param imageUrl of the event to be created
     */
    public void createEvent(String name, String description, String imageUrl, String givenDate)
            throws Exception {
        Event event = new Event();
        Date date = new SimpleDateFormat("dd.mm.yyyy").parse(givenDate);
        event.setCategory(chosenCategory.getValue());
        event.setCreator(currentUser);
        event.setDate(date);
        event.setDescription(description);
        event.setName(name);
        event.setImageUrl(imageUrl);
        eventRepository.createEvent(event);
    }


}
