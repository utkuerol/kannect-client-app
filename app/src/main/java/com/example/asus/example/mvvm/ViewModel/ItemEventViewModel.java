package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;

import java.util.Date;
import java.util.List;

import javax.swing.text.View;

public class ItemEventViewModel extends ViewModel {

    private MutableLiveData<Event> event;
    private Context context;

    public ItemEventViewModel(MutableLiveData<Event> event, Context context) {
        this.context = context;
        this.event = event;
    }

    public MutableLiveData<Event> getEvent() {
        return event;
    }

    public void setEvent(MutableLiveData<Event> event) {}

    public void onItemClick(View view) {

        //context.startActivity(EventFeedActivity.launchWithDetails(view.getContext(), mChosenEvent));
    }




    public String getName() {
    }

    public Date getDate() {
    }

    public String getDateAsString() {}

    public String getDescription() {
    }

    public User getCreator() {
    }

    public String getCreatorName() {}

    public Category getCategory() {
    }

    public Subcategory getSubcategory() {
    }

    public String getImageUrl() {
    }

    public List<User> getParticipants() {
    }
}
