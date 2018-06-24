package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;

import java.util.List;

import javax.swing.text.View;

public class EventViewModel extends ViewModel {

    private MutableLiveData<List<Event>> events;
    private Context context;

    public EventViewModel(Context context) {
        this.context = context;
    }

    public void setEventsToSearchResults(String query) {
    }

    public void setEventsFilteredByCategory(Category category) {
    }

    public void setEventsFilteredBySubcategory(Subcategory subcategory) {
    }

    public void setEventsToParticipatingEvents() {
    }


    public void onItemClick(View view) {

        //context.startActivity(EventFeedActivity.launchWithDetails(view.getContext(), mChosenEvent));
    }

    public List<Event> getEvents() {
        return events.getValue();
    }


}
