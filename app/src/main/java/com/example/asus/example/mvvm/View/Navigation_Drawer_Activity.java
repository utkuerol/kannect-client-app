package com.example.asus.example.mvvm.View;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.asus.example.R;

public class Navigation_Drawer_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation__drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
        UserSearchResultsFragment userSearchResultsFragment = new UserSearchResultsFragment();
        EventSearchResultsFragment eventSearchResultsFragment = new EventSearchResultsFragment();
        GroupSearchResultsFragment groupSearchResultsFragment = new GroupSearchResultsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, searchInputFragment);
        transaction.add(R.id.content_frame, userSearchResultsFragment);
        transaction.add(R.id.content_frame, eventSearchResultsFragment);
        transaction.add(R.id.content_frame, groupSearchResultsFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }



}
