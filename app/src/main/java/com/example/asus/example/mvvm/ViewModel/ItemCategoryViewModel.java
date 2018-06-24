package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;

import java.util.List;

import javax.swing.text.View;

/**
 * ViewModel class for itemcategories, that is responsible for preparing and managing the data for Views,
 * which need a list of itemcategories, by handling the communication of the View with the
 * Recyclerview element.
 */
public class ItemCategoryViewModel extends ViewModel {

    private MutableLiveData<Category> chosenCategory;
    private Context context;

    /**
     * Creates an instance with the given application context.
     *
     * @param context of the application.
     */
    public ItemCategoryViewModel(MutableLiveData<Category> chosenCategory, Context context) {
        this.chosenCategory = chosenCategory;
        this.context = context;
    }

    /**
     * method will be invoked by clicking on the item
     *
     * @param view the current View
     */
    public void onItemClick(View view) {

    }

    public MutableLiveData<Category> getChosenCategory() {
        return chosenCategory;
    }

    public void setChosenCategory(Category chosenCategory) {
        MutableLiveData<Category> a = new MutableLiveData<Category>();
        a.setValue(chosenCategory);
        this.chosenCategory = a;
    }

    public List<Subcategory> getSubcategories() {
    }

    public String getName() {
    }

    public void createGroup(String name, String description, String imageUrl) {
    }

    public void createEvent(String name, String description, String imageUrl) {
    }


}
