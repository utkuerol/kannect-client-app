package com.example.asus.example;

import android.arch.lifecycle.MutableLiveData;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Repository.EventRepository;
import com.example.asus.example.mvvm.ViewModel.EventViewModel;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    EventViewModel eventViewModel = new EventViewModel();
    EventRepository eventRepository = new EventRepository();

    @Test
    public void exampleMockito() {
        MutableLiveData<List<Event>> events = new MutableLiveData<>(); //create the method answer mock you want. fill with events of your choice
        Mockito.when(eventRepository.getEvents("asd")).thenReturn(events);
        Assert.assertTrue(eventViewModel.getEvents().getValue().equals(events));

        //just to show how mockito works, this test doesnt make any sense it will always return true
        //just apply this when you need an external method in your unit test
        //also use setup to initiliaze stuff
        //most of the methods dont need to be tested
    }


}