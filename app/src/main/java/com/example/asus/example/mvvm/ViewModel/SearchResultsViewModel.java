package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.ViewModel;

import javax.naming.Context;
import javax.swing.text.View;

/**
 * ViewModel class for search functions, responsible for passing the given search query from View
 * to other Views and starting them.
 */
public class SearchResultsViewModel extends ViewModel {

    private String query;
    private Context context;

    /**
     * Creates an instance with the given query and application context.
     *
     * @param query   given.
     * @param context of the application.
     */
    public SearchResultsViewModel(String query, Context context) {
        this.query = query;
    }

    /**
     * Starts the SearchResultsActivity with the given query string.
     *
     * @param view
     */
    public void onSearchClick(View view) {

    }
}
