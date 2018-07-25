package com.example.asus.example.mvvm.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Repository.CategoryRepository;

import java.util.List;

/**
 * ViewModel class for categories, that is responsible for preparing and managing the data for Views,
 * which need a list of categories, by handling the communication of the View with the
 * CategoryRepository class, which has the category business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class CategoryViewModel extends AndroidViewModel {


    private MutableLiveData<List<Category>> categories;
    private CategoryRepository categoryRepository;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
    }


    public void init() {
        this.categoryRepository = new CategoryRepository();
    }

    /**
     * Gets the list of categories.
     * @return observable list of categories.
     */
    public MutableLiveData<List<Category>> getCategories() {
        return categories;
    }

    /**
     * Sets categories to all categories.
     */
    public void setCategoriesToAllCategories() {
        categories = categoryRepository.getCategories("");
    }

}
