package com.example.asus.example.mvvm.View.Adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.Model.Entities.User;

import java.util.Collections;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterViewHolder> {
    private List<User> usersList;

    public UserAdapter() {
        this.usersList = Collections.emptyList();
    }

    @Override public UserAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemUserBinding itemUserBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_user,
                        parent, false);
        return new UserAdapterViewHolder(itemUserBinding);
    }

    @Override public void onBindViewHolder(UserAdapterViewHolder holder, int position) {
        holder.bindUser(usersList.get(position));
    }

    @Override public int getItemCount() {
        return usersList.size();
    }

    public void setUserList(List<User> UsersList) {
        this.usersList = UsersList;
    }

    public static class UserAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemUserBinding mItemUserBinding;

        public UserAdapterViewHolder(ItemUserBinding itemUserBinding) {
            super(itemUserBinding.itemUser);
            this.mItemUserBinding = itemUserBinding;
        }

        void bindUser(User User) {
            if (mItemUserBinding.getUserViewModel() == null) {
                mItemUserBinding.setUserViewModel(
                        new ItemUserViewModel(User, itemView.getContext()));
            } else {
                mItemUserBinding.getUserViewModel().setUser(User);
            }
        }
    }
}

