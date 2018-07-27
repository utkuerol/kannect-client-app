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
import android.widget.Button;
import android.widget.ImageView;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentGroupFeedBinding;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.PostAdapter;
import com.example.asus.example.mvvm.ViewModel.ItemGroupViewModel;

/**
 * Activity displaying informations about the group and its posts
 */
public class GroupFeedFragment extends Fragment implements View.OnClickListener {

    private Group group;
    private FragmentGroupFeedBinding fragmentGroupFeedBinding;
    private ItemGroupViewModel itemGroupViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        fragmentGroupFeedBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_group_feed, parent, false);
        //set viewmodel
        itemGroupViewModel = ViewModelProviders.of(this).get(ItemGroupViewModel.class);
        itemGroupViewModel.init(group, getContext());

        //set adapter
        final PostAdapter postAdapter = new PostAdapter();

        fragmentGroupFeedBinding.groupFeedPostRV.setAdapter(postAdapter);


        itemGroupViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    postAdapter.setPostList(itemGroupViewModel.getGroupFeed());
                    fragmentGroupFeedBinding.groupFeedPostRV.setAdapter(postAdapter);

                }
            }
        });


        Button joinGroupBt = (Button) fragmentGroupFeedBinding.joinGroupBt;
        joinGroupBt.setOnClickListener(this);

        ImageView createPostInGroupIV = (ImageView) fragmentGroupFeedBinding.createPostInGroupIV;
        createPostInGroupIV.setOnClickListener(this);

        fragmentGroupFeedBinding.groupFeedPostRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return fragmentGroupFeedBinding.getRoot();
    }


    @Override
    public void onClick(View v) {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();

        switch (v.getId()) {
            case R.id.joinGroupBt: {
                if (fragmentGroupFeedBinding.joinGroupBt.getText().equals("BEITRETEN")) {
                    fragmentGroupFeedBinding.joinGroupBt.setText("BEIGETRETEN");
                    itemGroupViewModel.getCurrentUser().getValue().getJoinedGroups().add(group);
                } else {
                    itemGroupViewModel.getCurrentUser().getValue().getJoinedGroups().remove(group);
                    fragmentGroupFeedBinding.joinGroupBt.setText("BEITRETEN");
                }
                break;
            }

            case R.id.createPostInGroupIV: {
                navigation_drawer_activity.launchNewGroupPostFragment(group);
                break;
            }
        }
    }

    public void setGroup(Group group) {
        this.group = group;
    }

}
