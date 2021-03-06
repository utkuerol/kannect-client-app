package com.example.asus.example.mvvm.View.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.ItemSubcategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.ViewModel.ItemSubcategoryViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Adapter class for Recycler View.
 * Handles the items which will be shown in the Recycler View.
 */
public class SubcategoryAdapter extends RecyclerView.Adapter<SubcategoryAdapter.SubcategoryAdapterViewHolder> {
    private List<Subcategory> subcategoryList;
    private OnItemClickListenerSubcategory listener;


    /**
     * sets the item click listener for the adapter.
     *
     * @param listener which will be set.
     */
    public void setListener(OnItemClickListenerSubcategory listener) {

        this.listener = listener;
    }
    /**
     * Constructor.
     * Initializes the private subCategoryList attribute.
     */
    public SubcategoryAdapter() {
        this.subcategoryList = Collections.emptyList();
    }

    /**
     * Method inflates the View, meaning it creates the layout for every list item, using DataBindingUtil inflate method.
     * @param parent parent ViewGroup of the inflated view.
     * @param viewType indicates what type of view should be inflated.
     * @return a new instance of the SubCategoryAdapterViewHolder with the created Binding object.
     */
    @Override public SubcategoryAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemSubcategoryBinding itemSubcategoryBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_subcategory,
                        parent, false);
        return new SubcategoryAdapterViewHolder(itemSubcategoryBinding, parent.getContext().getApplicationContext());
    }

    /**
     * Method which binds a ViewHolder to a position in the Recycler View, using the bindUser method.
     * And sets the onClickListener for the ViewHolder.
     * @param holder ViewHolder which will be shown.
     * @param position of the item in the list.
     */
    @Override public void onBindViewHolder(SubcategoryAdapterViewHolder holder, int position) {
        holder.bindSubcategory(subcategoryList.get(position));
        final Subcategory model = subcategoryList.get(position);
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
        return subcategoryList.size();
    }

    /**
     * sets the list of groups which will be shown in the ui.
     * @param subcategoryList list of messages
     */
    public void setSubcategoryList(List<Subcategory> subcategoryList) {
        this.subcategoryList = subcategoryList;
    }

    /**
     * Nested Class.
     * Builds for every item in the Recycler View its View Model.
     */
    public static class SubcategoryAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemSubcategoryBinding mItemSubcategoryBinding;
        private Context context;

        /**
         * Constructor.
         * Creates a SubcategoryAdapterViewHolder object.
         * @param itemSubcategoryBinding the Binding object of the new SubcategoryAdapterViewHolder.
         * @param context of the Application.
         */
        public SubcategoryAdapterViewHolder(ItemSubcategoryBinding itemSubcategoryBinding, Context context) {
            super(itemSubcategoryBinding.itemSubcategory);
            this.mItemSubcategoryBinding = itemSubcategoryBinding;
            this.context = context;
        }


        /**
         * Method which binds an item of the recycler view to its View Model if that wasn´t already done.
         * @param subcategory which will be bound.
         */
        void bindSubcategory(Subcategory subcategory) {
            if (mItemSubcategoryBinding.getItemSubcategoryViewModel() == null) {
                ItemSubcategoryViewModel itemSubcategoryViewModel = new ItemSubcategoryViewModel();
                itemSubcategoryViewModel.init(subcategory, context);
                mItemSubcategoryBinding.setItemSubcategoryViewModel(itemSubcategoryViewModel);
            } else {
                mItemSubcategoryBinding.getItemSubcategoryViewModel().init(subcategory, context);
            }
        }
    }
}

