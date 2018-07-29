package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentGroupsInCategoryBinding;
import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.GroupAdapter;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerGroup;
import com.example.asus.example.mvvm.ViewModel.GroupViewModel;

/**
 * Fragment for the view, to show all groups that exist in the chosen Category.
 */
public class GroupsInCategoryFragment extends Fragment {

    private Category category;


    /**
     * Method which will be called when this fragment is created.
     * Inflates the View, sets the ViewModel and the Adapter with the right onClickListener for the
     * RecyclerView.
     * Observes getCurrentUser to check if there is a value or a null object.
     * @param inflater           inflates the layout on the screen
     * @param parent             of this ViewGroup
     * @param savedInstanceState state of the Application as a Bundle
     * @return the outermost View in the layout file associated with the Binding.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        //set viewmodel
        final GroupViewModel groupViewModel = ViewModelProviders.of(this).get(GroupViewModel.class);
        groupViewModel.init(getContext());


        //set adapter
        final GroupAdapter groupAdapter = new GroupAdapter();
        OnItemClickListenerGroup listener = new OnItemClickListenerGroup() {
            @Override
            public void onItemClick(Group item) {
                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchGroupFeedFragment(item);
            }
        };
        groupAdapter.setListener(listener);

        //set binding
        final FragmentGroupsInCategoryBinding fragmentGroupsInCategoryBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_groups_in_category, parent, false);
        fragmentGroupsInCategoryBinding.groupsInCategoryGroupRV.setAdapter(groupAdapter);

        groupViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    groupViewModel.setGroupsFilteredByCategory(category);
                    groupAdapter.setGroupList(groupViewModel.getGroups().getValue());
                    fragmentGroupsInCategoryBinding.groupsInCategoryGroupRV.setAdapter(groupAdapter);

                } else {
                    Toast.makeText(getContext(), "Server Error", Toast.LENGTH_SHORT);
                }

            }
        });

        fragmentGroupsInCategoryBinding.groupsInCategoryGroupRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return fragmentGroupsInCategoryBinding.getRoot();
    }

    /**
     * sets the category of which all groups will be shown.
     * @param category which the user clicked on.
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}
