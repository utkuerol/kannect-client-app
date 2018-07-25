package com.example.asus.example.mvvm.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;



/**
 * ViewModel class for search functions, responsible for passing the given search query from View
 * to other Views and starting them.
 */
public class SearchResultsViewModel extends AndroidViewModel {

    private String query;

    public SearchResultsViewModel(@NonNull Application application) {
        super(application);
    }


    public void init(String query) {
        this.query = query;
    }


}
