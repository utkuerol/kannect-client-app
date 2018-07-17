package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Repository.CategoryRepository;

import java.util.List;

import javax.swing.text.View;

/**
 * ViewModel class for one specific category, and is responsible for preparing and managing the data for Views,
 * which need the information of this particular category, by handling the communication of the View with the
 * CategoryRepository class, which has the category business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class ItemCategoryViewModel extends ViewModel {

    private MutableLiveData<Category> chosenCategory;
    private Context context;
    private CategoryRepository categoryRepository:

    /**
     * Creates an instance with the chosenCategory and the application context.
     *
     * @param chosenCategory to set
     * @param context        of the application.
     */
    public ItemCategoryViewModel(MutableLiveData<Category> chosenCategory, Context context) {
        this.chosenCategory = chosenCategory;
        this.context = context;
    }

    /**
     * Starts the CategoryEventPageActivity with the chosen subcategory.
     *
     * @param view
     */
    public void onItemClickEvent(View view) {

    }

    /**
     * Starts the CategoryGroupPageActivity with the chosen subcategory.
     *
     * @param view
     */
    public void onItemClickGroup(View view) {

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
    public void setChosenCategory(MutableLiveData<Category> chosenCategory) {
        this.chosenCategory = chosenCategory;
    }

    /**
     * Gets list of subcategories of the category.
     * @return list of subcategories.
     */
    public List<Subcategory> getSubcategories() {
    }

    /**
     * Gets the name of the category
     * @return name of the category
     */
    public String getName() {
    }

    /**
     * Creates a new group in the chosen category.
     * @param name of the group to be created
     * @param description of the group to be created
     * @param imageUrl of the group to be created
     */
    public void createGroup(String name, String description, String imageUrl) {
    }

    /**
     * Creates a new event in the chosen category.
     * @param name of the event to be created
     * @param description of the event to be created
     * @param imageUrl of the event to be created
     */
    public void createEvent(String name, String description, String imageUrl) {
    }


}
