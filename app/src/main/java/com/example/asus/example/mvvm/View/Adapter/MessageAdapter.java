package com.example.asus.example.mvvm.View.Adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.Model.Entities.Message;

import java.util.Collections;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageAdapterViewHolder> {
    private List<Message> MessagesList;

    public MessageAdapter() {
        this.MessagesList = Collections.emptyList();
    }

    @Override public MessageAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMessageBinding itemMessageBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_Message,
                        parent, false);
        return new MessageAdapterViewHolder(itemMessageBinding);
    }

    @Override public void onBindViewHolder(MessageAdapterViewHolder holder, int position) {
        holder.bindMessage(MessagesList.get(position));
    }

    @Override public int getItemCount() {
        return MessagesList.size();
    }

    public void setMessageList(List<Message> MessagesList) {
        this.MessagesList = MessagesList;
    }

    public static class MessageAdapterViewHolder extends RecyclerView.ViewHolder {

        ItemMessageBinding mItemMessageBinding;

        public MessageAdapterViewHolder(ItemMessageBinding itemMessageBinding) {
            super(itemMessageBinding.itemMessage);
            this.mItemMessageBinding = itemMessageBinding;
        }

        void bindMessage(Message Message) {
            if (mItemMessageBinding.getMessageViewModel() == null) {
                mItemMessageBinding.setMessageViewModel(
                        new ItemMessageViewModel(Message, itemView.getContext()));
            } else {
                mItemMessageBinding.getMessageViewModel().setMessage(Message);
            }
        }
    }
}
