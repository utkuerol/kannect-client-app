package com.example.asus.example.mvvm.View.Adapter;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.ItemGroupBinding;
import com.example.asus.example.mvvm.Interfaces.OnItemClickListenerGroup;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.ViewModel.ItemGroupViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Adapter class for Recycler View.
 * Handles the items which will be shown in the Recycler View.
 */
public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupAdapterViewHolder> {
    private List<Group> groupsList;
    private OnItemClickListenerGroup listener;
    /**
     * Constructor.
     * Initializes the private groupsList attribute.
     */
    public GroupAdapter() {
        this.groupsList = Collections.emptyList();

    }

    public void setListener(OnItemClickListenerGroup listener) {
        this.listener = listener;
    }

    /**
     * Method inflates the View, meaning it creates the layout for every list item, using DataBindingUtil inflate method.
     * @param parent parent ViewGroup of the inflated view.
     * @param viewType indicates what type of view should be inflated.
     * @return a new instance of the GroupAdapterViewHolder with the created Binding object.
     */
    @Override public GroupAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemGroupBinding itemGroupBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_group,
                        parent, false);
        return new GroupAdapterViewHolder(itemGroupBinding);
    }

    /**
     * Method which binds a ViewHolder to a position in the Recycler View, using the bindUser method.
     * @param holder ViewHolder which will be shown.
     * @param position of the item in the list.
     */
    @Override public void onBindViewHolder(GroupAdapterViewHolder holder, int position) {
        holder.bindGroup(groupsList.get(position));
        final Group model = groupsList.get(position);
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
        return groupsList.size();
    }

    /**
     * sets the list of groups which will be shown in the ui.
     * @param GroupsList list of groups
     */
    public void setGroupList(List<Group> GroupsList) {
        this.groupsList = GroupsList;
    }

    /**
     * Nested Class.
     * Builds for every item in the Recycler View its View Model.
     */
    public static class GroupAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemGroupBinding mItemGroupBinding;

        /**
         * Constructor.
         * Creates an GroupAdapterViewHolder object.
         * @param mItemGroupBinding the Binding object of the new GroupAdapterViewHolder.
         */
        public GroupAdapterViewHolder(ItemGroupBinding mItemGroupBinding) {
            super(mItemGroupBinding.itemGroup);
            this.mItemGroupBinding = mItemGroupBinding;
        }

        /**
         * Method which binds an item of the recycler view to its View Model if that wasn´t already done.
         * @param group which will be bound.
         */
        void bindGroup(Group group) {
            MutableLiveData<Group> g = new MutableLiveData<>();
            g.setValue(group);
            if (mItemGroupBinding.getItemGroupViewModel() == null) {
                mItemGroupBinding.setItemGroupViewModel(
                        new ItemGroupViewModel(g, itemView.getContext()));
            } else {
                mItemGroupBinding.getItemGroupViewModel().setChosenGroup(group);
            }
        }
    }
}
