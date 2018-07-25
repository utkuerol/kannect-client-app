package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.ViewModel;


/**
 * ViewModel class for search functions, responsible for passing the given search query from View
 * to other Views and starting them.
 */
public class SearchResultsViewModel extends ViewModel {

    private String query;



    public void init(String query) {
        this.query = query;
    }


}
