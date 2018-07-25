package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class EventFeedFragment extends Fragment {
    private Event event;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        //Set binding
        final FragmentEventFeedBinding fragmentEventFeedBinding = FragmentEventFeedBinding.inflate(inflater, parent, false);

        //set viewmodel
        final ItemEventViewModel itemEventViewModel = ViewModelProviders.of(this).get(ItemEventViewModel.class);
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


        fragmentEventFeedBinding.eventFeedRV.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return inflater.inflate(R.layout.fragment_event_feed, parent, false);
    }


    public void setEvent(Event event) {
        this.event = event;
    }
}
