package com.example.asus.example.mvvm.ViewModel;

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

@RunWith(MockitoJUnitRunner.class)
public class ItemCategoryViewModelTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private GroupRepository groupRepository;
    private String eventName;
    private String groupName;
    private String description;
    private User currentUser;

    @Before
    public void setUp() throws Exception {
        groupRepository = Mockito.mock(GroupRepository.class);
        eventName = "Event";
        groupName = "Group";
        description = "Description of Group or Event, just some Text";
        currentUser.setEmail("hans@gmail.com");
        currentUser.setImageUrl("");


    }

    @Test
    public void createGroup() {
    }

    @Test
    public void createEvent() {
    }
}