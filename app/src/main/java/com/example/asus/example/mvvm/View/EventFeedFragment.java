package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentEventFeedBinding;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.View.Adapter.OnItemClickListenerPost;
import com.example.asus.example.mvvm.View.Adapter.PostAdapter;
import com.example.asus.example.mvvm.ViewModel.ItemEventViewModel;

/**
 * The Activity displayed when accessing an event. It shows informations about the event and all the posts
 * related to it.
 */
public class EventFeedFragment extends Fragment {
    private Event event;
    private ItemEventViewModel itemEventViewModel;
    private FragmentEventFeedBinding fragmentEventFeedBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        Event event = new Event();
        MutableLiveData<Event> e = new MutableLiveData<>();
        e.setValue(event);
        fragmentEventFeedBinding = FragmentEventFeedBinding.inflate(inflater, parent, false);
        //set viewmodel
        itemEventViewModel = ViewModelProviders.of(this).get(ItemEventViewModel.class);
        itemEventViewModel.init(event, getContext());

        PostAdapter postAdapter = new PostAdapter();
        OnItemClickListenerPost listener = new OnItemClickListenerPost() {
            @Override
            public void onItemClick(Post item) {
                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchShowPostFragment(item);
            }
        };
        postAdapter.setListener(listener);
        postAdapter.setPostList(itemEventViewModel.getEventFeed());
        fragmentEventFeedBinding.eventFeedRV.setAdapter(postAdapter);
        fragmentEventFeedBinding.eventFeedRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
        // Defines the xml file for the fragment

        return inflater.inflate(R.layout.fragment_event_feed, parent, false);
    }


    public void setEvent(Event event) {
        this.event = event;
    }
}
