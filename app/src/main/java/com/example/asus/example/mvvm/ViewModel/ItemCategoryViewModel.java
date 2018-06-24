package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;

import java.util.List;

import javax.swing.text.View;

public class ItemCategoryViewModel extends ViewModel {

    private MutableLiveData<Category> chosenCategory;
    private Context context;

    public ItemCategoryViewModel(MutableLiveData<Category> chosenCategory, Context context) {
        this.chosenCategory = chosenCategory;
        this.context = context;
    }

    public void onItemClick(View view) {

    }

    public MutableLiveData<Category> getChosenCategory() {
        return chosenCategory;
    }

    public void setChosenCategory(MutableLiveData<Category> chosenCategory) {
        this.chosenCategory = chosenCategory;
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
