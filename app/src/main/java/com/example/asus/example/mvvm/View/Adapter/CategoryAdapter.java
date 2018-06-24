package com.example.asus.example.mvvm.View.Adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.Model.Entities.Category;

import java.util.Collections;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryAdapterViewHolder> {

    private List<Category> CategorysList;

    public CategoryAdapter() {
        this.CategorysList = Collections.emptyList();
    }

    @Override public CategoryAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCategoryBinding itemCategoryBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_Category,
                        parent, false);
        return new CategoryAdapterViewHolder(itemCategoryBinding);
    }

    @Override public void onBindViewHolder(CategoryAdapterViewHolder holder, int position) {
        holder.bindCategory(CategorysList.get(position));
    }

    @Override public int getItemCount() {
        return CategorysList.size();
    }

    public void setCategoryList(List<Category> CategorysList) {
        this.CategorysList = CategorysList;
    }

    public static class CategoryAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemCategoryBinding mItemCategoryBinding;

        public CategoryAdapterViewHolder(ItemCategoryBinding itemCategoryBinding) {
            super(itemCategoryBinding.itemCategory);
            this.mItemCategoryBinding = itemCategoryBinding;
        }

        void bindCategory(Category Category) {
            if (mItemCategoryBinding.getCategoryViewModel() == null) {
                mItemCategoryBinding.setCategoryViewModel(
                        new ItemCategoryViewModel(Category, itemView.getContext()));
            } else {
                mItemCategoryBinding.getCategoryViewModel().setCategory(Category);
            }
        }
    }
}
