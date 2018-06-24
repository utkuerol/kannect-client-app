package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.asus.example.mvvm.Model.Entities.Subcategory;

import javax.naming.Context;
import javax.swing.text.View;


/**
 * ViewModel class for itemSubcategory, that is responsible for preparing and managing the data for Views,
 * which need a list of itemSubcategory, by handling the communication of the View with the
 * Recyclerview element.
 */
public class ItemSubcategoryView extends ViewModel {

    private MutableLiveData<Subcategory> subcategory;
    private Context context;

    /**
     * Creates an instance with the given application context.
     *
     * @param context of the application.
     */
    public ItemSubcategoryView(Subcategory subcategory, Context context) {
        MutableLiveData<Subcategory> s = new MutableLiveData<Subcategory>();
        this.subcategory = s;
        this.context = context;
    }

    /**
     * method will be invoked by clicking on the event
     *
     * @param view the current View
     */
    public void onItemClickEvent(View view) {

    }

    /**
     * method will be invoked by clicking on the group
     *
     * @param view the current View
     */
    public void onItemClickGroup(View view) {

    }

    public String getName() {
    }

    public void createGroup(String name, String description, String imageUrl) {
    }

    public void createEvent(String name, String description, String imageUrl) {
    }

}
