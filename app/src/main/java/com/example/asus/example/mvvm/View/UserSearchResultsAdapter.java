package com.example.asus.example.mvvm.View;

import android.support.v7.widget.RecyclerView;

import com.example.asus.example.R;

public class UserSearchResultsAdapter extends RecyclerView.Adapter<UserSearchResultsAdapter.UserSearchResultAdapterViewHolder> {

    //List<user> users


    public UserSearchResultsAdapter() {
        // create empty list
    }

    /**
     * Method inflates the View, meaning it creates the layout for every list item, using DataBindingUtil inflate method.
     * @param parent parent ViewGroup of the inflated view.
     * @param viewType indicates what type of view should be inflated.
     * @return a new instance of the UserSearchResultAdapterViewHolder.
     */
    @Override
    public UserSearchResultAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }


    /**
     * Method which binds a ViewHolder to a position in the Recycler View, using the bindUser method.
     * @param holder ViewHolder which will be.
     * @param position of the item in the list.
     */
    @Override public void onBindViewHolder(PeopleAdapterViewHolder holder, int position) {
        // binds user in the position with the nested class method
        holder.bindPeople(peopleList.get(position));
    }

    /**
     * method to get the size of the List of users which will be shown in the ui.
     * @return length of list
     */
    @Override public int getItemCount() {
        return userList.size();
    }

    /**
     * sets the list of user which will be shown in the ui.
     * @param users list of users
     */
    public void setUserList(List<User> users) {
        this.userList = userList;
    }


    /**
     * Nested Class.
     *
     */
    public static class UserSearchResultAdapterViewHolder extends RecyclerView.ViewHolder {

        UserBinding UserBinding;

        public UserSearchResultAdapterViewHolder(UserBinding userBinding) {

        }

        public void bindUser(User user) {
            //creates view model for every user ...

            if (mItemPeopleBinding.getPeopleViewModel() == null) {
                mItemPeopleBinding.setPeopleViewModel(
                        new ItemPeopleViewModel(people, itemView.getContext()));
            } else {
                mItemPeopleBinding.getPeopleViewModel().setPeople(people);
            }
        }
    }

}
