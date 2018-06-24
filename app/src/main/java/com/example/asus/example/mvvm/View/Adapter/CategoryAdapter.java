package com.example.asus.example.mvvm.View.Adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.Model.Entities.Category;

import java.util.Collections;
import java.util.List;

/**
 * Adapter class for Recycler View.
 * Handles the items which will be shown in the Recycler View.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryAdapterViewHolder> {


    private List<Category> categoryList;

    /**
     * Constructor.
     * Initializes the private categoryList attribute.
     */
    public CategoryAdapter() {
        this.categoryList = Collections.emptyList();
    }


    /**
     * Method inflates the View, meaning it creates the layout for every list item, using DataBindingUtil inflate method.
     * @param parent parent ViewGroup of the inflated view.
     * @param viewType indicates what type of view should be inflated.
     * @return a new instance of the CategoryAdapterViewHolder with the created Binding object.
     */
    @Override public CategoryAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCategoryBinding itemCategoryBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_Category,
                        parent, false);
        return new CategoryAdapterViewHolder(itemCategoryBinding);
    }

    /**
     * Method which binds a ViewHolder to a position in the Recycler View, using the bindUser method.
     * @param holder ViewHolder which will be shown.
     * @param position of the item in the list.
     */
    @Override public void onBindViewHolder(CategoryAdapterViewHolder holder, int position) {
        holder.bindCategory(categoryList.get(position));
    }

    /**
     * method to get the size of the List of items that will be shown in the ui.
     * @return size of the list
     */
    @Override public int getItemCount() {
        return categoryList.size();
    }

    /**
     * sets the list of groups which will be shown in the ui.
     * @param categoryList list of Categories
     */
    public void setCategoryList(List<Category> CategorysList) {
        this.categoryList = CategorysList;
    }

    /**
     * Nested Class.
     * Builds for every item in the Recycler View its View Model.
     */
    public static class CategoryAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemCategoryBinding mItemCategoryBinding;

        /**
         * Constructor.
         * Creates an UserAdapterViewHolder object.
         * @param itemCategoryBinding the Binding object of the new CategoryAdapterViewHolder.
         */
        public CategoryAdapterViewHolder(ItemCategoryBinding itemCategoryBinding) {
            super(itemCategoryBinding.itemCategory);
            this.mItemCategoryBinding = itemCategoryBinding;
        }

        /**
         * Method which binds an item of the recycler view to its View Model if that wasn´t already done.
         * @param category which will be bound.
         */
        void bindCategory(Category category) {
            if (mItemCategoryBinding.getCategoryViewModel() == null) {
                mItemCategoryBinding.setCategoryViewModel(
                        new ItemCategoryViewModel(category, itemView.getContext()));
            } else {
                mItemCategoryBinding.getCategoryViewModel().setCategory(category);
            }
        }
    }
}
