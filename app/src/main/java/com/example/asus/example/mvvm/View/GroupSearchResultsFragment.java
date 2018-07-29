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
import com.example.asus.example.databinding.FragmentGroupSearchResultBinding;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.GroupAdapter;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerGroup;
import com.example.asus.example.mvvm.ViewModel.GroupViewModel;

import java.util.List;

public class GroupSearchResultsFragment extends Fragment {

    private String query;

    /**
     * sets the search Query, for which all groups that match it will be found.
     *
     * @param query which was typed in b the user.
     */
    public void setQuery(String query) {
        this.query = query;
    }


    /**
     *  Method which will be called when this fragment is created.
     *  Inflates the View, sets the ViewModel and the Adapter with the right onClickListener for the
     *  RecyclerView.
     *  Observes getCurrentUser to check if there is a value or a null object.
     * @param inflater inflates the layout on the screen
     * @param parent of this ViewGroup
     * @param savedInstanceState state of the Application as a Bundle
     * @return the outermost View in the layout file associated with the Binding.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        //set viewmodel
        final GroupViewModel groupViewModel = ViewModelProviders.of(this).get(GroupViewModel.class);
        groupViewModel.init(getContext().getApplicationContext());

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
        final FragmentGroupSearchResultBinding fragmentGroupSearchResultBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_group_search_result, parent, false);
        fragmentGroupSearchResultBinding.groupSearchResultGroupRV.setAdapter(groupAdapter);


        final Observer<List<Group>> groupsObserver = new Observer<List<Group>>() {
            @Override
            public void onChanged(@Nullable List<Group> groups) {
                if (groups != null) {
                    groupAdapter.setGroupList(groups);
                    fragmentGroupSearchResultBinding.groupSearchResultGroupRV.setAdapter(groupAdapter);

                } else {
                    Toast.makeText(getContext(), "Server Error", Toast.LENGTH_SHORT);
                }
            }
        };


        groupViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    groupViewModel.setGroupsToSearchResults(query);
                    groupViewModel.getGroups().observe(GroupSearchResultsFragment.this, groupsObserver);
                }
            }
        });

        fragmentGroupSearchResultBinding.groupSearchResultGroupRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return fragmentGroupSearchResultBinding.getRoot();
    }
}
