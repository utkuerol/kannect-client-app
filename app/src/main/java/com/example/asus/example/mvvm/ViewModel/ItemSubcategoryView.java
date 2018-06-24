package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.asus.example.mvvm.Model.Entities.Subcategory;

import javax.naming.Context;
import javax.swing.text.View;

public class ItemSubcategoryView extends ViewModel {

    private MutableLiveData<Subcategory> subcategory;
    private Context context;

    public ItemSubcategoryView(Subcategory subcategory, Context context) {
        MutableLiveData<Subcategory> s = new MutableLiveData<Subcategory>();
        this.subcategory = s;
        this.context = context;
    }

    public void onItemClickEvent(View view) {

    }

    public void onItemClickGroup(View view) {

    }

    public String getName() {
    }

    public void createGroup(String name, String description, String imageUrl) {
    }

    public void createEvent(String name, String description, String imageUrl) {
    }

}
