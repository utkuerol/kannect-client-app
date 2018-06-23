package com.example.asus.example.mvvm.View.Adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.Model.Entities.Post;

import java.util.Collections;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostAdapterViewHolder> {
    private List<Post> postsList;

    public PostAdapter() {
        this.postsList = Collections.emptyList();
    }

    @Override public PostAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemPostBinding itemPostBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_post,
                        parent, false);
        return new PostAdapterViewHolder(itemPostBinding);
    }

    @Override public void onBindViewHolder(PostAdapterViewHolder holder, int position) {
        holder.bindPost(postsList.get(position));
    }

    @Override public int getItemCount() {
        return postsList.size();
    }

    public void setPostList(List<Post> postsList) {
        this.postsList = postsList;
    }

    public static class PostAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemPostBinding mItemPostBinding;

        public PostAdapterViewHolder(ItemPostBinding itemPostBinding) {
            super(itemPostBinding.itemPost);
            this.mItemPostBinding = itemPostBinding;
        }

        void bindPost(Post post) {
            if (mItemPostBinding.getPostViewModel() == null) {
                mItemPostBinding.setPostViewModel(
                        new ItemPostViewModel(post, itemView.getContext()));
            } else {
                mItemPostBinding.getPostViewModel().setPost(post);
            }
        }
    }
}
