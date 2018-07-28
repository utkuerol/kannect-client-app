package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.view.View;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.PostRepository;
import com.example.asus.example.mvvm.View.Navigation_Drawer_Activity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import static org.junit.Assert.*;

public class ItemEventViewModelTest {
    @Mock
    private PostRepository postRepository;

    private Post post;
    private ItemEventViewModel itemEventViewModel;

    @Mock
    private View view;


    @Mock
    private Context context;

    private Event chosenEvent;

    Navigation_Drawer_Activity navigation_drawer_activity;
    private MutableLiveData<Event> event;
    private MutableLiveData<User> currentUserLiveData;
    private User currentUser;


   @Before
    public void setUp() {
        postRepository = Mockito.spy(PostRepository.class);
        event = new MutableLiveData<Event>();
        chosenEvent = new Event();
        event.setValue(chosenEvent);
        currentUser = new User();
        currentUserLiveData.setValue(currentUser);
        navigation_drawer_activity = Mockito.spy(Navigation_Drawer_Activity.class);
        itemEventViewModel = new ItemEventViewModel();
        itemEventViewModel.setCurrentUser(currentUserLiveData);
        itemEventViewModel.setEvent(event);







        post = new Post();
        //Mockito.when(postRepository.createPost(post)).thenReturn(post);
        Mockito.doNothing().when(navigation_drawer_activity).launchEventFeedFragment(event.getValue());

    }


    @Test
    public void createPost() {
        //Assert.assertTrue(itemEventViewModel.createPost(view));
    }
}