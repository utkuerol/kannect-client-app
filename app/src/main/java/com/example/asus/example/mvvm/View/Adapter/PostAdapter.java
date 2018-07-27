package com.example.asus.example.mvvm.View.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.ItemPostBinding;
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
     * sets the item click listener for the adapter.
     *
     * @param listener which will be set.
     */
    public void setListener(OnItemClickListenerPost listener) {

        this.listener = listener;
    }

    /**
     * Constructor.
     * Initializes the private postList attribute.
     */
    public PostAdapter() {
        this.postsList = Collections.emptyList();
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
        return new PostAdapterViewHolder(itemPostBinding, parent.getContext().getApplicationContext());
    }

    /**
     * Method which binds a ViewHolder to a position in the Recycler View, using the bindUser method.
     * And sets the onClickListener for the ViewHolder.
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
        private Context context;

        /**
         * Constructor.
         * Creates an PostAdapterViewHolder object.
         * @param itemPostBinding the Binding object of the new PostAdapterViewHolder.
         * @param context of the Application.
         */
        public PostAdapterViewHolder(ItemPostBinding itemPostBinding, Context context) {
            super(itemPostBinding.itemPost);
            this.mItemPostBinding = itemPostBinding;
            this.context = context;
        }

        /**
         * Method which binds an item of the recycler view to its View Model if that wasn´t already done.
         * @param post which will be bound.
         */
        void bindPost(Post post) {

            if (mItemPostBinding.getItemPostViewModel() == null) {
                ItemPostViewModel itemPostViewModel = new ItemPostViewModel();
                itemPostViewModel.init(post, context);
                mItemPostBinding.setItemPostViewModel(itemPostViewModel);
            } else {
                mItemPostBinding.getItemPostViewModel().init(post, context);
            }
        }
    }
}
