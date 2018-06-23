package com.example.asus.example.mvvm.View;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.Model.Entities.Event;

import java.util.List;

public class EventSearchResultAdapter {

    //List<event> events


    public EventSearchResultAdapter() {
        // create empty list
    }

    @Override
    public EventSearchResultAdapter.EventSearchResultAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create layout for every event item inside a view holder...

        return null;
    }


    @Override public void onBindViewHolder(PeopleAdapterViewHolder holder, int position) {
        // binds events in the position with the nested class method
    }

    @Override public int getItemCount() {
    }

    public void setEventList(List<Event> events) {
    }


    public static class EventSearchResultAdapterViewHolder extends RecyclerView.ViewHolder {


        public EventViewModel(EventBinding eventBinding) {

        }

        void bindEvent(Event event) {
            //creates view model for every event ...

        }
    }
}
