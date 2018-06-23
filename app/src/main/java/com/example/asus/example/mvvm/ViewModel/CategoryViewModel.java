package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Category;

import java.util.List;

public class CategoryViewModel extends ViewModel {

    private MutableLiveData<List<Category>> categories;
    private Context context;


}
