package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Category;

import java.util.List;

import javax.swing.text.View;

public class CategoryViewModel extends ViewModel {

    private MutableLiveData<List<Category>> categories;
    private Context context;

    public CategoryViewModel(Context context) {
        this.context = context;
    }

    public MutableLiveData<List<Category>> getCategories() {
        return categories;
    }

    public void setCategoriesToAllCategories() {}

    public void onItemClick(View view) {

    }
}
