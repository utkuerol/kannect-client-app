package com.example.asus.example.mvvm.View.Adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;

import java.util.Collections;
import java.util.List;

public class SubcategoryAdapter extends RecyclerView.Adapter<SubcategoryAdapter.SubcategoryAdapterViewHolder> {
    private List<Subcategory> SubcategorysList;

    public SubcategoryAdapter() {
        this.SubcategorysList = Collections.emptyList();
    }

    @Override public SubcategoryAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemSubcategoryBinding itemSubcategoryBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_Subcategory,
                        parent, false);
        return new SubcategoryAdapterViewHolder(itemSubcategoryBinding);
    }

    @Override public void onBindViewHolder(SubcategoryAdapterViewHolder holder, int position) {
        holder.bindSubcategory(SubcategorysList.get(position));
    }

    @Override public int getItemCount() {
        return SubcategorysList.size();
    }

    public void setSubcategoryList(List<Subcategory> SubcategorysList) {
        this.SubcategorysList = SubcategorysList;
    }

    public static class SubcategoryAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemSubcategoryBinding mItemSubcategoryBinding;

        public SubcategoryAdapterViewHolder(ItemSubcategoryBinding itemSubcategoryBinding) {
            super(itemSubcategoryBinding.itemSubcategory);
            this.mItemSubcategoryBinding = itemSubcategoryBinding;
        }

        void bindSubcategory(Subcategory Subcategory) {
            if (mItemSubcategoryBinding.getSubcategoryViewModel() == null) {
                mItemSubcategoryBinding.setSubcategoryViewModel(
                        new ItemSubcategoryViewModel(Subcategory, itemView.getContext()));
            } else {
                mItemSubcategoryBinding.getSubcategoryViewModel().setSubcategory(Subcategory);
            }
        }
    }
}

