package com.example.asus.example.mvvm.View.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.ItemEventBinding;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.ViewModel.ItemEventViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Adapter class for Recycler View.
 * Handles the items which will be shown in the Recycler View.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventAdapterViewHolder> {

    private List<Event> eventsList;
    private OnItemClickListenerEvent listener;

    /**
     * Constructor.
     * Initializes the private EventList attribute.
     */

    public EventAdapter() {
        this.eventsList = Collections.emptyList();
    }

    public void setListener(OnItemClickListenerEvent listener) {

        this.listener = listener;
    }


    /**
     * Method inflates the View, meaning it creates the layout for every list item, using DataBindingUtil inflate method.
     * @param parent parent ViewGroup of the inflated view.
     * @param viewType indicates what type of view should be inflated.
     * @return a new instance of the EventAdapterViewHolder with the created Binding object.
     */
    @Override public EventAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemEventBinding itemEventBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_event,
                        parent, false);
        return new EventAdapterViewHolder(itemEventBinding, parent.getContext().getApplicationContext());
    }

    /**
     * Method which binds a ViewHolder to a position in the Recycler View, using the bindUser method.
     * @param holder ViewHolder which will be shown.
     * @param position of the item in the list.
     */
    @Override public void onBindViewHolder(EventAdapterViewHolder holder, int position) {
        holder.bindEvent(eventsList.get(position));
        final Event model = eventsList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(model);
                }
            }
        });
    }

    /**
     * method to get the size of the List of items that will be shown in the ui.
     * @return size of the list
     */
    @Override public int getItemCount() {
        return eventsList.size();
    }

    /**
     * sets the list of events which will be shown in the ui.
     * @param eventsList list of events
     */
    public void setEventList(List<Event> eventsList) {
        this.eventsList = eventsList;
    }

    /**
     * Nested Class.
     * Builds for every item in the Recycler View its View Model.
     */
    public static class EventAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemEventBinding mItemEventBinding;
        private Context context;

        /**
         * Constructor.
         * Creates an EventAdapterViewHolder object.
         * @param itemEventBinding the Binding object of the new EventAdapterViewHolder.
         */
        public EventAdapterViewHolder(ItemEventBinding itemEventBinding, Context context) {
            super(itemEventBinding.itemEvent);
            this.mItemEventBinding = itemEventBinding;
            this.context = context;
        }

        /**
         * Method which binds an item of the recycler view to its View Model if that wasn´t already done.
         * @param event which will be bound.
         */
        void bindEvent(Event event) {

            if (mItemEventBinding.getItemEventViewModel() == null) {
                ItemEventViewModel itemEventViewModel = new ItemEventViewModel();
                itemEventViewModel.init(event, context);
                mItemEventBinding.setItemEventViewModel(itemEventViewModel);
            } else {
                mItemEventBinding.getItemEventViewModel().init(event, context);
            }
        }
    }
}
