package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.asus.example.R;
import com.example.asus.example.databinding.NavHeaderNavigationDrawerBinding;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemUserViewModel;

public class Navigation_Drawer_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final com.example.asus.example.databinding.ActivityNavigationDrawerBinding binding;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_navigation__drawer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ItemUserViewModel itemUserViewModel = ViewModelProviders.of(this).get(ItemUserViewModel.class);
        itemUserViewModel.init();

        itemUserViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    NavHeaderNavigationDrawerBinding navHeaderNavigationDrawerBinding = NavHeaderNavigationDrawerBinding.bind(binding.navView.getHeaderView(0));
                    navHeaderNavigationDrawerBinding.setItemUserViewModel(itemUserViewModel);
                }
            }
        });
        //DataBindingUtil.inflate(getLayoutInflater(), R.layout.nav_header_navigation__drawer_, binding.navView, false);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button a = (Button) findViewById(R.id.newEventInCategoryButton);


        launchPersonalFeedFragment();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_navigation__drawer_drawer, menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
         //Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
        return super.onOptionsItemSelected(item);
    }
            return true;
}*/



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_feed) {
            launchPersonalFeedFragment();
        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_profile) {
            launchUserProfileFragment();
            //TODO methode muss noch geändert werden so dass alle Posts of user angezeigt werden
        } else if (id == R.id.nav_groups) {
            launchGroupFragments();
        } else if (id == R.id.nav_events) {
            launchEventFragments();
        } else if (id == R.id.nav_search) {
            launchSearchFragments();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void launchPersonalFeedFragment() {

        PersonalFeedFragment personalFeedFragment = new PersonalFeedFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, personalFeedFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchUserProfileFragment() {
        UserProfileFragment userProfileFragment = new UserProfileFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, userProfileFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchGroupFragments() {
        CategoriesGroupFragment categoriesGroupFragment = new CategoriesGroupFragment();
        MyGroupsFragment myGroupsFragment = new MyGroupsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, categoriesGroupFragment);
        transaction.add(R.id.content_frame, myGroupsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchEventFragments() {
        CategoriesEventFragment categoriesEventFragment = new CategoriesEventFragment();
        MyEventsFragment myEventsFragment = new MyEventsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, categoriesEventFragment);
        transaction.add(R.id.content_frame, myEventsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchSearchFragments() {
        SearchInputFragment searchInputFragment = new SearchInputFragment();
        // UserSearchResultsFragment userSearchResultsFragment = new UserSearchResultsFragment();
        // EventSearchResultsFragment eventSearchResultsFragment = new EventSearchResultsFragment();
        // GroupSearchResultsFragment groupSearchResultsFragment = new GroupSearchResultsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, searchInputFragment);
        //transaction.add(R.id.content_frame, userSearchResultsFragment);
        //transaction.add(R.id.content_frame, eventSearchResultsFragment);
        //transaction.add(R.id.content_frame, groupSearchResultsFragment);

        transaction.addToBackStack(null);
        transaction.commit();

    }

    public void launchCategoriesEventFragment() {
        CategoriesEventFragment categoriesEventFragment = new CategoriesEventFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, categoriesEventFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    public void launchCategoriesGroupFragment() {
        CategoriesGroupFragment categoriesGroupFragment = new CategoriesGroupFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, categoriesGroupFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchEventFeedFragment() {
        EventFeedFragment eventFeedFragment = new EventFeedFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, eventFeedFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchEventSearchResultsInFragment() {
        EventSearchResultsFragment eventSearchResultsFragment = new EventSearchResultsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, eventSearchResultsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchEventInCategoryFragment() {
        EventsInCategoryFragment eventInCategoryFragment = new EventsInCategoryFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, eventInCategoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchEventsInSubcategoryFragment() {
        EventsInSubcategoryFragment eventsInSubcategoryFragment = new EventsInSubcategoryFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, eventsInSubcategoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchGroupFeedFragment() {
        GroupFeedFragment groupFeedFragment = new GroupFeedFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, groupFeedFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchGroupSearchResultsFragment() {
        GroupSearchResultsFragment groupSearchResultsFragment = new GroupSearchResultsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, groupSearchResultsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchGroupsInCategoryFragment() {
        GroupsInCategoryFragment groupsInCategoryFragment = new GroupsInCategoryFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, groupsInCategoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchGroupsInSubcategoryFragment() {
        GroupsInSubcategoryFragment groupsInSubcategoryFragment = new GroupsInSubcategoryFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, groupsInSubcategoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchMyEventsFragment() {
        MyEventsFragment myEventsFragment = new MyEventsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, myEventsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchMyGroupsFragment() {
        MyGroupsFragment myGroupsFragment = new MyGroupsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, myGroupsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchNewEventInCategoryFragment() {
        NewEventInCategoryFragment newEventInCategoryFragment = new NewEventInCategoryFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, newEventInCategoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchNewEventInSubategoryFragment() {
        NewEventInSubcategoryFragment newEventInSubategoryFragment = new NewEventInSubcategoryFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, newEventInSubategoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchNewEventPostFragment() {
        NewEventPostFragment newEventPostFragment = new NewEventPostFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, newEventPostFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchNewGroupInCategoryFragment() {
        NewGroupInCategoryFragment newGroupInCategoryFragment = new NewGroupInCategoryFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, newGroupInCategoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchNewGroupInSubcategoryFragment() {
        NewGroupInSubcategoryFragment newGroupInSubcategoryFragment = new NewGroupInSubcategoryFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, newGroupInSubcategoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchGroupPostFragment() {
        NewGroupPostFragment newGroupPostFragment = new NewGroupPostFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, newGroupPostFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchNewUserPostFragment() {
        NewUserPostFragment newUserPostFragment = new NewUserPostFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, newUserPostFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchSearchInputFragment() {
        SearchInputFragment searchInputFragment = new SearchInputFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, searchInputFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchShowPostFragment() {
        ShowPostFragment showPostFragment = new ShowPostFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, showPostFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchSubcategoriesEventFragment() {
        SubcategoriesEventFragment subcategoriesEventFragment = new SubcategoriesEventFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, subcategoriesEventFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchSubcategoriesGroupFragment() {
        SubcategoriesGroupFragment subcategoriesGroupFragment = new SubcategoriesGroupFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, subcategoriesGroupFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchSubscriptionsFragment() {
        SubscriptionsFragment subscriptionsFragment = new SubscriptionsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, subscriptionsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchUserSearchResultsFragment() {
        UserSearchResultsFragment userSearchResultsFragment = new UserSearchResultsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, userSearchResultsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
