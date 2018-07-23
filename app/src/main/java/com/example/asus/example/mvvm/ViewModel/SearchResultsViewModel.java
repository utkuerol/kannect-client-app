package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.view.View;



/**
 * ViewModel class for search functions, responsible for passing the given search query from View
 * to other Views and starting them.
 */
public class SearchResultsViewModel extends ViewModel {

    private String query;
    private Context context;


    public SearchResultsViewModel() {

    }

    public void init(String query) {
        this.query = query;
    }

    /**
     * Starts the SearchResultsActivity with the given query string.
     *
     * @param view
     */
    public void onSearchClick(View view) {
        //context.startActivity(SearchResultActivity.launchWithDetails(view.getContext(), query));
    }
}
