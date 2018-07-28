package com.example.asus.example.mvvm.ViewModel;

import android.view.View;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.GroupRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.LinkedList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ItemCategoryViewModelTest {

    ItemCategoryViewModel itemCategoryViewModel;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private GroupRepository groupRepository;

    private Category category;
    private List<Event> mockEvents;
    private Event mockEvent1;
    private Event getMockEvent2;
    @Before
    public void setUp() {
        itemCategoryViewModel = new ItemCategoryViewModel();
        groupRepository = Mockito.spy(GroupRepository.class);
        Group group = new Group();
        mockEvent1 = new Event();
        getMockEvent2 = new Event();
        mockEvents = new LinkedList<>();
        mockEvents.add(mockEvent1);
        mockEvents.add(getMockEvent2);

        Mockito.doNothing().when(groupRepository).createGroup(group);

        category.setEvents(mockEvents);
        itemCategoryViewModel.setChosenCategory(new Category());



    }

    @Test
    public void createGroup() {

    }

    @Test
    public void createEvent(View view) {
    }
}