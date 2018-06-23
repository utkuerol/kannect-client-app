package com.example.asus.example.mvvm.View.Adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.Model.Entities.Group;

import java.util.Collections;
import java.util.List;

public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.GroupsAdapterViewHolder> {
    private List<Group> groupsList;

    public GroupsAdapter() {
        this.groupsList = Collections.emptyList();
    }

    @Override public GroupsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemGroupBinding itemGroupBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_group,
                        parent, false);
        return new GroupsAdapterViewHolder(itemGroupBinding);
    }

    @Override public void onBindViewHolder(GroupsAdapterViewHolder holder, int position) {
        holder.bindGroup(groupsList.get(position));
    }

    @Override public int getItemCount() {
        return groupsList.size();
    }

    public void setGroupList(List<Group> GroupsList) {
        this.groupsList = GroupsList;
    }

    public static class GroupsAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemGroupBinding mItemGroupBinding;

        public GroupsAdapterViewHolder(ItemGroupBinding itemGroupBinding) {
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
