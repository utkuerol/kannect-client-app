package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Repository.CategoryRepository;

import javax.naming.Context;
import javax.swing.text.View;

/**
 * ViewModel class for one specific subcategory, and is responsible for preparing and managing the data for Views,
 * which need the information of this particular subcategory, by handling the communication of the View with the
 * CategoryRepository class, which has the category and subcategory business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class ItemSubcategoryView extends ViewModel {

    private MutableLiveData<Subcategory> subcategory;
    private Context context;
    private CategoryRepository categoryRepository;

    /**
     * Creates an instance with the given chosenSubcategory and application context.
     *
     * @param chosenSubcategory subcategory
     * @param context           of the application.
     */
    public ItemSubcategoryView(Subcategory chosenSubcategory, Context context) {
        this.subcategory = subcategory;
        this.context = context;
    }

    /**
     * Starts the SubcategoryEventPageActivity with the chosen subcategory.
     * @param view
     */
    public void onItemClickEvent(View view) {

    }

    /**
     * Starts the SubcategoryGroupPageActivity with the chosen subcategory.
     * @param view
     */
    public void onItemClickGroup(View view) {

    }

    /**
     * Gets the name of the subcategory.
     * @return
     */
    public String getName() {
    }

    /**
     * Creates a new group in the chosen subcategory with the user-given parameters.
     * @param name of the group to be created.
     * @param description of the group to be created.
     * @param imageUrl of the group to be created.
     */
    public void createGroup(String name, String description, String imageUrl) {
    }


    /**
     * Creates a new event in the chosen subcategory with the user-given parameters.
     * @param name of the event to be created.
     * @param description of the event to be created.
     * @param imageUrl of the event to be created.
     *//

    public void createEvent(String name, String description, String imageUrl) {
    }

}
