package com.example.asus.example.mvvm.View.Adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.Model.Entities.Event;

import java.util.Collections;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventAdapterViewHolder> {

    private List<Event> EventsList;

    public EventAdapter() {
        this.EventsList = Collections.emptyList();
    }

    @Override public EventAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemEventBinding itemEventBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_Event,
                        parent, false);
        return new EventAdapterViewHolder(itemEventBinding);
    }

    @Override public void onBindViewHolder(EventAdapterViewHolder holder, int position) {
        holder.bindEvent(EventsList.get(position));
    }

    @Override public int getItemCount() {
        return EventsList.size();
    }

    public void setEventList(List<Event> EventsList) {
        this.EventsList = EventsList;
    }

    public static class EventAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemEventBinding mItemEventBinding;

        public EventAdapterViewHolder(ItemEventBinding itemEventBinding) {
            super(itemEventBinding.itemEvent);
            this.mItemEventBinding = itemEventBinding;
        }

        void bindEvent(Event Event) {
            if (mItemEventBinding.getEventViewModel() == null) {
                mItemEventBinding.setEventViewModel(
                        new ItemEventViewModel(Event, itemView.getContext()));
            } else {
                mItemEventBinding.getEventViewModel().setEvent(Event);
            }
        }
    }
}
