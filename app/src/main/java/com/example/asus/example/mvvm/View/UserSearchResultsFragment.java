package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentUserSearchResultBinding;
import com.example.asus.example.mvvm.Interfaces.OnItemClickListenerUser;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.UserAdapter;
import com.example.asus.example.mvvm.ViewModel.UserViewModel;


/**
 * Fragment for the view, to show all users which match the search query.
 */
public class UserSearchResultsFragment extends Fragment {

    private String query;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        //get extra arguments from the initiating activity


        //set viewmodel
        UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.init();
        userViewModel.setUsersToSearchResults(query);

        //set adapter
        UserAdapter userAdapter = new UserAdapter();
        OnItemClickListenerUser listener = new OnItemClickListenerUser() {
            @Override
            public void onItemClick(User user) {

                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchUserProfileFragment(user);

            }
        };
        userAdapter.setListener(listener);
        userAdapter.setUserList(userViewModel.getUsers().getValue());

        //set databinding, define the xml of the fragment
        FragmentUserSearchResultBinding fragmentUserSearchResultBinding = FragmentUserSearchResultBinding.inflate(inflater, parent, false);
        fragmentUserSearchResultBinding.userSearchResultUserRV.setAdapter(userAdapter);
        fragmentUserSearchResultBinding.userSearchResultUserRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return inflater.inflate(R.layout.fragment_user_search_result, parent, false);
        //TODO: observe livedata somehow

    }

    public void setQuery(String query) {

        this.query = query;
    }

}
