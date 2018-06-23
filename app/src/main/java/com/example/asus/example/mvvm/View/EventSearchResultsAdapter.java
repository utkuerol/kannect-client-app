package com.example.asus.example.mvvm.View;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.asus.example.mvvm.Model.Entities.Event;

import java.util.List;

public class EventSearchResultsAdapter {

    //List<event> events


    public EventSearchResultsAdapter() {
        // create empty list
    }

    @Override
    public EventSearchResultsAdapter.EventSearchResultAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

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


    public static class EventSearchResultsAdapterViewHolder extends RecyclerView.ViewHolder {


        public EventSearchResultsAdapterViewHolder(EventBinding eventBinding) {

        }

        void bindEvent(Event event) {
            //creates view model for every event ...

        }
    }
}
