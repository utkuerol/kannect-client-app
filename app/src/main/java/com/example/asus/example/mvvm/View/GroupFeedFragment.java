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
import android.widget.Toast;

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

    /**
     * Method which will be called when this fragment is created.
     * Inflates the View, sets the ViewModel and the Adapter with the right onClickListener for the
     * RecyclerView.
     *
     * @param inflater           inflates the layout on the screen
     * @param parent             of this ViewGroup
     * @param savedInstanceState state of the Application as a Bundle
     * @return the outermost View in the layout file associated with the Binding.
     */
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

                } else {
                    Toast.makeText(getContext(), "Server Error", Toast.LENGTH_SHORT);
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


    /**
     * Method which handles the click on the joinGroupButton and the createPostInGroupIV ImageView
     * icon.
     * Directs the User to the view for creating a new Post, if the createPostInGroupIV was clicked
     * on. If the User clicked on the joinGroupBt, it checks whether or not the user is already part
     * of the group or not, and handles the according actions.
     * @param v
     */
    @Override
    public void onClick(View v) {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();

        switch (v.getId()) {
            case R.id.joinGroupBt: {
                if (fragmentGroupFeedBinding.joinGroupBt.getText().equals("BEITRETEN")) {
                    fragmentGroupFeedBinding.joinGroupBt.setText("BEIGETRETEN");
                    itemGroupViewModel.joinGroup();
                } else {
                    itemGroupViewModel.leaveGroup();
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

    /**
     * sets the group of which the feed will be shown.
     * @param group of which the feed will be shown.
     */
    public void setGroup(Group group) {
        this.group = group;
    }

}
