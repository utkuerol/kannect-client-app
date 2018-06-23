package com.example.asus.example.mvvm.View;

import android.support.v7.widget.RecyclerView;

import com.example.asus.example.R;

public class UserSearchResultAdapter {

    //List<user> users


    public UserSearchResultAdapter() {
        // create empty list
    }

    @Override
    public UserSearchResultAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create layout for every user item inside a view holder...

        ItemPeopleBinding itemPeopleBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_people,
                        parent, false);
        return new PeopleAdapterViewHolder(itemPeopleBinding);
    }


    @Override public void onBindViewHolder(PeopleAdapterViewHolder holder, int position) {
        // binds user in the position with the nested class method
        holder.bindPeople(peopleList.get(position));
    }

    @Override public int getItemCount() {
        return userList.size();
    }

    public void setPeopleList(List<User> users) {
        this.userList = userList;
    }


    public static class UserSearchResultAdapterViewHolder extends RecyclerView.ViewHolder {

        UserBinding UserBinding;

        public ItemUserViewModel(UserBinding userBinding) {

        }

        void bindUser(User user) {
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
