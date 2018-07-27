package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentEventFeedBinding;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerPost;
import com.example.asus.example.mvvm.View.Adapter.PostAdapter;
import com.example.asus.example.mvvm.ViewModel.ItemEventViewModel;

import java.util.List;

/**
 * The Activity displayed when accessing an event. It shows informations about the event and all the posts
 * related to it.
 */

public class EventFeedFragment extends Fragment implements View.OnClickListener {
    private Event event;
    private FragmentEventFeedBinding fragmentEventFeedBinding;
    private ItemEventViewModel itemEventViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        fragmentEventFeedBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_event_feed, parent, false);
        itemEventViewModel = ViewModelProviders.of(this).get(ItemEventViewModel.class);
        itemEventViewModel.init(event, getContext().getApplicationContext());

        //Set adapter
        final PostAdapter postAdapter = new PostAdapter();
        OnItemClickListenerPost listener = new OnItemClickListenerPost() {
            @Override
            public void onItemClick(Post item) {
                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchShowPostFragment(item);
            }
        };
        postAdapter.setListener(listener);

        //Set binding
        fragmentEventFeedBinding.eventFeedRV.setAdapter(postAdapter);


        final Observer<List<Post>> postsObserver = new Observer<List<Post>>() {
            @Override
            public void onChanged(@Nullable List<Post> posts) {
                if (posts != null) {
                    postAdapter.setPostList(itemEventViewModel.getEventFeed().getValue());
                    fragmentEventFeedBinding.eventFeedRV.setAdapter(postAdapter);

                }
            }
        };

        itemEventViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    itemEventViewModel.getEventFeed().observe(EventFeedFragment.this, postsObserver);
                }
            }
        });

        Button participateBT = (Button) fragmentEventFeedBinding.participateBt;
        participateBT.setOnClickListener(this);

        ImageView createPostInEventIV = (ImageView) fragmentEventFeedBinding.createPostInEventIV;
        createPostInEventIV.setOnClickListener(this);

        fragmentEventFeedBinding.eventFeedRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return fragmentEventFeedBinding.getRoot();
    }

    @Override
    public void onClick(View v) {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();

        switch (v.getId()) {
            case R.id.participateBt: {
                if (fragmentEventFeedBinding.participateBt.getText().equals("particpate")) {
                    fragmentEventFeedBinding.participateBt.setText("participated");
                    itemEventViewModel.getCurrentUser().getValue().getParticipatedEvents().add(event);
                } else {
                    itemEventViewModel.getCurrentUser().getValue().getParticipatedEvents().remove(event);
                    fragmentEventFeedBinding.participateBt.setText("participate");
                }
                break;
            }

            case R.id.createPostInEventIV: {
                navigation_drawer_activity.launchNewEventPostFragment(event);
                break;
            }
        }
    }
    public void setEvent(Event event) {
        this.event = event;
    }
}
