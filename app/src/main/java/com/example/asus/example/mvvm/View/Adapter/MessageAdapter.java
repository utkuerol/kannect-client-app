package com.example.asus.example.mvvm.View.Adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.Model.Entities.Message;

import java.util.Collections;
import java.util.List;

/**
 * Adapter class for Recycler View.
 * Handles the items which will be shown in the Recycler View.
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageAdapterViewHolder> {
    private List<Message> messageList;

    /**
     * Constructor.
     * Initializes the private messageList attribute.
     */
    public MessageAdapter() {
        this.messageList = Collections.emptyList();
    }

    /**
     * Method inflates the View, meaning it creates the layout for every list item, using DataBindingUtil inflate method.
     * @param parent parent ViewGroup of the inflated view.
     * @param viewType indicates what type of view should be inflated.
     * @return a new instance of the MessageAdapterViewHolder with the created Binding object.
     */
    @Override public MessageAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMessageBinding itemMessageBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_Message,
                        parent, false);
        return new MessageAdapterViewHolder(itemMessageBinding);
    }

    /**
     * Method which binds a ViewHolder to a position in the Recycler View, using the bindUser method.
     * @param holder ViewHolder which will be shown.
     * @param position of the item in the list.
     */
    @Override public void onBindViewHolder(MessageAdapterViewHolder holder, int position) {
        holder.bindMessage(messageList.get(position));
    }

    /**
     * method to get the size of the List of items that will be shown in the ui.
     * @return size of the list
     */
    @Override public int getItemCount() {
        return messageList.size();
    }

    /**
     * sets the list of groups which will be shown in the ui.
     * @param messagesList list of messages
     */
    public void setMessageList(List<Message> messagesList) {
        this.messageList = messagesList;
    }

    /**
     * Nested Class.
     * Builds for every item in the Recycler View its View Model.
     */
    public static class MessageAdapterViewHolder extends RecyclerView.ViewHolder {

        ItemMessageBinding mItemMessageBinding;

        /**
         * Constructor.
         * Creates an MessageAdapterViewHolder object.
         * @param itemMessageBinding the Binding object of the new MessageAdapterViewHolder.
         */
        public MessageAdapterViewHolder(ItemMessageBinding itemMessageBinding) {
            super(itemMessageBinding.itemMessage);
            this.mItemMessageBinding = itemMessageBinding;
        }

        /**
         * Method which binds an item of the recycler view to its View Model if that wasn´t already done.
         * @param message which will be bound.
         */
        void bindMessage(Message message) {
            if (mItemMessageBinding.getMessageViewModel() == null) {
                mItemMessageBinding.setMessageViewModel(
                        new ItemMessageViewModel(message, itemView.getContext()));
            } else {
                mItemMessageBinding.getMessageViewModel().setMessage(message);
            }
        }
    }
}
