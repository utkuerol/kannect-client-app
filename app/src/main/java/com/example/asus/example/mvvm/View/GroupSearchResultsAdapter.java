package com.example.asus.example.mvvm.View;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;

import java.util.List;

public class GroupSearchResultsAdapter extends RecyclerView.Adapter<GroupSearchResultsAdapter.GroupSearchResultsAdapterViewHolder> {

    //groups


    public GroupSearchResultsAdapter() {
        //Create empty groups list
    }

    @Override
    public GroupSearchResultsAdapter.GroupSearchResultsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create layout for every group item inside a view holder...

        return null;
    }


    @Override public void onBindViewHolder(GroupSearchResultsAdapterViewHolder holder, int position) {
        // binds groups in the position with the nested class method
    }

    @Override public int getItemCount() {
    }

    public void setGroups(List<Group> groups) {
    }


    public static class GroupSearchResultsAdapterViewHolder extends RecyclerView.ViewHolder {


        public GroupSearchResultsAdapterViewHolder(GroupBinding groupBinding) {
        }

        void bindGroup(Group group) {
            //creates view model for every group ...
        }
    }
}
