package com.example.asus.example.mvvm.View.Adapter;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.ItemPostBinding;
import com.example.asus.example.mvvm.Interfaces.OnItemClickListenerPost;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.ViewModel.ItemPostViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Adapter class for Recycler View.
 * Handles the items which will be shown in the Recycler View.
 */
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostAdapterViewHolder> {

    private List<Post> postsList;
    private OnItemClickListenerPost listener;
    /**
     * Constructor.
     * Initializes the private postList attribute.
     */
    public PostAdapter() {
        this.postsList = Collections.emptyList();

    }


    public void setListener(OnItemClickListenerPost listener) {
        this.listener = listener;
    }

    /**
     * Method inflates the View, meaning it creates the layout for every list item, using DataBindingUtil inflate method.
     * @param parent parent ViewGroup of the inflated view.
     * @param viewType indicates what type of view should be inflated.
     * @return a new instance of the PostAdapterViewHolder with the created Binding object.
     */
    @Override public PostAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemPostBinding itemPostBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_post,
                        parent, false);
        return new PostAdapterViewHolder(itemPostBinding);
    }

    /**
     * Method which binds a ViewHolder to a position in the Recycler View, using the bindUser method.
     * @param holder ViewHolder which will be shown.
     * @param position of the item in the list.
     */
    @Override public void onBindViewHolder(PostAdapterViewHolder holder, int position) {
        holder.bindPost(postsList.get(position));
        final Post model = postsList.get(position);
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
        return postsList.size();
    }

    /**
     * sets the list of groups which will be shown in the ui.
     * @param postsList list of posts
     */
    public void setPostList(List<Post> postsList) {
        this.postsList = postsList;
    }

    /**
     * Nested Class.
     * Builds for every item in the Recycler View its View Model.
     */
    public static class PostAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemPostBinding mItemPostBinding;

        /**
         * Constructor.
         * Creates an PostAdapterViewHolder object.
         * @param itemPostBinding the Binding object of the new PostAdapterViewHolder.
         */
        public PostAdapterViewHolder(ItemPostBinding itemPostBinding) {
            super(itemPostBinding.itemPost);
            this.mItemPostBinding = itemPostBinding;
        }

        /**
         * Method which binds an item of the recycler view to its View Model if that wasn´t already done.
         * @param post which will be bound.
         */
        void bindPost(Post post) {
            MutableLiveData<Post> p = new MutableLiveData<>();
            p.setValue(post);
            if (mItemPostBinding.getItemPostViewModel() == null) {
                mItemPostBinding.setItemPostViewModel(
                        new ItemPostViewModel(p, itemView.getContext()));
            } else {
                mItemPostBinding.getItemPostViewModel().setPost(post);
            }
        }
    }
}
