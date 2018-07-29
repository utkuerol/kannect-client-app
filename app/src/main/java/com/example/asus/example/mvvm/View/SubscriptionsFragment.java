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
import com.example.asus.example.databinding.FragmentSubscriptionsBinding;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerUser;
import com.example.asus.example.mvvm.View.Adapter.UserAdapter;
import com.example.asus.example.mvvm.ViewModel.UserViewModel;

import java.util.List;

public class SubscriptionsFragment extends Fragment {

    private FragmentSubscriptionsBinding fragmentSubscriptionsBinding;

    private List<User> users;

    /**
     * Method which will be called when this fragment is created.
     * Inflates the View, sets the ViewModel and the Adapter with the right onClickListener for the
     * RecyclerView.
     * @param inflater           inflates the layout on the screen
     * @param parent             of this ViewGroup
     * @param savedInstanceState state of the Application as a Bundle
     * @return the outermost View in the layout file associated with the Binding.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        fragmentSubscriptionsBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_subscriptions, parent, false);
        //set viewmodel
        final UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.init(this.getContext().getApplicationContext());

        //set adapter
        final UserAdapter userAdapter = new UserAdapter();
        OnItemClickListenerUser listener = new OnItemClickListenerUser() {
            @Override
            public void onItemClick(User user) {

                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchUserProfileFragment(user);

            }
        };
        userAdapter.setListener(listener);
        userAdapter.setUserList(users);
        fragmentSubscriptionsBinding.subscriptionsUserRV.setAdapter(userAdapter);
        //set binding


        fragmentSubscriptionsBinding.subscriptionsUserRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return fragmentSubscriptionsBinding.getRoot();
    }


    /**
     * sets the list of users which the logged in user is subscribed to.
     * @param users list of user subscriptions.
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

}
