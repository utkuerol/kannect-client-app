package com.example.asus.example.mvvm.View.Adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.Model.Entities.Group;

import java.util.Collections;
import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupAdapterViewHolder> {
    private List<Group> groupsList;

    public GroupAdapter() {
        this.groupsList = Collections.emptyList();
    }

    @Override public GroupAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemGroupBinding itemGroupBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_group,
                        parent, false);
        return new GroupAdapterViewHolder(itemGroupBinding);
    }

    @Override public void onBindViewHolder(GroupAdapterViewHolder holder, int position) {
        holder.bindGroup(groupsList.get(position));
    }

    @Override public int getItemCount() {
        return groupsList.size();
    }

    public void setGroupList(List<Group> GroupsList) {
        this.groupsList = GroupsList;
    }

    public static class GroupAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemGroupBinding mItemGroupBinding;

        public GroupAdapterViewHolder(ItemGroupBinding itemGroupBinding) {
            super(itemGroupBinding.itemGroup);
            this.mItemGroupBinding = itemGroupBinding;
        }

        void bindGroup(Group Group) {
            if (mItemGroupBinding.getGroupViewModel() == null) {
                mItemGroupBinding.setGroupViewModel(
                        new ItemGroupViewModel(Group, itemView.getContext()));
            } else {
                mItemGroupBinding.getGroupViewModel().setGroup(Group);
            }
        }
    }
}
