package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentUserProfileBinding;
import com.example.asus.example.mvvm.Interfaces.OnItemClickListenerPost;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.PostAdapter;
import com.example.asus.example.mvvm.ViewModel.ItemUserViewModel;

/**
 * User Profile Activity to show all Posts for this User
 */
public class UserProfileFragment extends Fragment {


    private User user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        User user = (User) getArguments().getSerializable("user");

        //set viewmodel
        ItemUserViewModel itemUserViewModel = ViewModelProviders.of(this).get(ItemUserViewModel.class);
        itemUserViewModel.init(user);

        //set adapter
        PostAdapter postAdapter = new PostAdapter();
        postAdapter.setPostList(itemUserViewModel.getUserProfile());
        OnItemClickListenerPost listener = new OnItemClickListenerPost() {
            @Override
            public void onItemClick(Post post) {

                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchShowPostFragment(post);

            }
        };
        postAdapter.setListener(listener);


        //set binding
        FragmentUserProfileBinding fragmentUserProfileBinding = FragmentUserProfileBinding.inflate(inflater, parent, false);
        fragmentUserProfileBinding.userProfilePostRV.setAdapter(postAdapter);
        fragmentUserProfileBinding.userProfilePostRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
        fragmentUserProfileBinding.setItemUserViewModel(itemUserViewModel);
        //TODO: observe livedata somehow

        return inflater.inflate(R.layout.fragment_user_profile, parent, false);
    }


    public void setUser(User user) {
        this.user = user;
    }
}
