package com.example.asus.example.mvvm.View.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.ItemUserBinding;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemUserViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Adapter class for Recycler View.
 * Handles the items which will be shown in the Recycler View.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterViewHolder> {
    private List<User> usersList;
    private OnItemClickListenerUser listener;


    public void setListener(OnItemClickListenerUser listener) {

        this.listener = listener;
    }
    /**
     * Constructor.
     * Initializes the private usersList attribute.
     */
    public UserAdapter() {
        this.usersList = Collections.emptyList();
    }


    /**
     * Method inflates the View, meaning it creates the layout for every list item, using DataBindingUtil inflate method.
     * @param parent parent ViewGroup of the inflated view.
     * @param viewType indicates what type of view should be inflated.
     * @return a new instance of the UserAdapterViewHolder with the created Binding object.
     */
    @Override public UserAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemUserBinding itemUserBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_user,
                        parent, false);
        return new UserAdapterViewHolder(itemUserBinding, parent.getContext().getApplicationContext());
    }

    /**
     * Method which binds a ViewHolder to a position in the Recycler View, using the bindUser method.
     * @param holder ViewHolder which will be shown.
     * @param position of the item in the list.
     */
    @Override public void onBindViewHolder(UserAdapterViewHolder holder, int position) {
        holder.bindUser(usersList.get(position));
        final User model = usersList.get(position);
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
        return usersList.size();
    }


    /**
     * sets the list of groups which will be shown in the ui.
     * @param userList list of Users
     */
    public void setUserList(List<User> userList) {
        this.usersList = userList;
    }

    /**
     * Nested Class.
     * Builds for every item in the Recycler View its View Model.
     */
    public static class UserAdapterViewHolder extends RecyclerView.ViewHolder {

        private final Context context;
        private ItemUserBinding mItemUserBinding;

        /**
         * Constructor.
         * Creates an UserAdapterViewHolder object.
         * @param itemUserBinding the Binding object of the new UserAdapterViewHolder.
         */
        public UserAdapterViewHolder(ItemUserBinding itemUserBinding, Context context) {
            super(itemUserBinding.itemUser);
            this.mItemUserBinding = itemUserBinding;
            this.context = context;
        }

        /**
         * Method which binds an item of the recycler view to its View Model if that wasn´t already done.
         * @param user which will be bound.
         */
        void bindUser(User user) {
            if (mItemUserBinding.getItemUserViewModel() == null) {
                ItemUserViewModel itemUserViewModel = new ItemUserViewModel();
                itemUserViewModel.init(user, context);
                mItemUserBinding.setItemUserViewModel(itemUserViewModel);
            } else {
                mItemUserBinding.getItemUserViewModel().init(user, context);
            }
        }
    }
}

