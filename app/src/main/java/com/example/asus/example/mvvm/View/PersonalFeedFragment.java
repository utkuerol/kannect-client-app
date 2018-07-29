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
import android.widget.ImageView;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentPersonalFeedBinding;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerPost;
import com.example.asus.example.mvvm.View.Adapter.PostAdapter;
import com.example.asus.example.mvvm.ViewModel.ItemPostViewModel;
import com.example.asus.example.mvvm.ViewModel.PostViewModel;

import java.util.List;

/**
 * Personal Feed Activity to show all Posts for this signed user of his groups , posts , events
 */
public class PersonalFeedFragment extends Fragment implements View.OnClickListener {

    private FragmentPersonalFeedBinding fragmentPersonalFeedBinding;

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

        fragmentPersonalFeedBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_personal_feed, parent, false);

        //set viewmodel
        final PostViewModel postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        final ItemPostViewModel itemPostViewModel = ViewModelProviders.of(this).get(ItemPostViewModel.class);

        //set adapter
        final PostAdapter postAdapter = new PostAdapter();

        OnItemClickListenerPost listener = new OnItemClickListenerPost() {
            @Override
            public void onItemClick(Post post) {

                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchShowPostFragment(post);

            }
        };
        postAdapter.setListener(listener);

        //set databinding
        ImageView personalFeedCreatePostIV = (ImageView) fragmentPersonalFeedBinding.personalFeedCreatePostIV;
        personalFeedCreatePostIV.setOnClickListener(this);

        fragmentPersonalFeedBinding.personalFeedPostRV.setAdapter(postAdapter);

        postViewModel.init(this.getContext().getApplicationContext());

        final Observer<List<Post>> postsObserver = new Observer<List<Post>>() {
            @Override
            public void onChanged(@Nullable List<Post> posts) {
                if (posts != null) {
                    for (final Post post : posts) {
                        itemPostViewModel.init(post, PersonalFeedFragment.this.getContext().getApplicationContext());
                        itemPostViewModel.getOwnerUser().observe(PersonalFeedFragment.this, new Observer<User>() {
                            @Override
                            public void onChanged(@Nullable User user) {
                                if (user != null) {
                                    post.setOwnerUser(user);
                                }
                            }
                        });
                        itemPostViewModel.getOwnerEvent().observe(PersonalFeedFragment.this, new Observer<Event>() {
                            @Override
                            public void onChanged(@Nullable Event event) {
                                if (event != null) {
                                    post.setOwnerEvent(event);
                                }
                            }
                        });
                        itemPostViewModel.getOwnerGroup().observe(PersonalFeedFragment.this, new Observer<Group>() {
                            @Override
                            public void onChanged(@Nullable Group group) {
                                if (group != null) {
                                    post.setOwnerGroup(group);
                                }
                            }
                        });
                        if (posts.get(posts.size() - 1).getId() == post.getId()) {
                            postAdapter.setPostList(posts);
                        }
                    }
                    fragmentPersonalFeedBinding.personalFeedPostRV.setAdapter(postAdapter);
                }
            }
        };

        postViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    postViewModel.setPostsToPersonalFeed();
                    postViewModel.getPosts().observe(PersonalFeedFragment.this, postsObserver);
                }
            }
        });


        fragmentPersonalFeedBinding.personalFeedPostRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return fragmentPersonalFeedBinding.getRoot();
    }

    /**
     * Method which will be called, when personalFeedCreatePostIV is clicked.
     * Directs user to the view of creating a new post.
     * @param v which was clicked on.
     */
    @Override
    public void onClick(View v) {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
        switch (v.getId()) {
            case R.id.personalFeedCreatePostIV:
                navigation_drawer_activity.launchNewUserPostFragment();
                break;
        }
    }


}
