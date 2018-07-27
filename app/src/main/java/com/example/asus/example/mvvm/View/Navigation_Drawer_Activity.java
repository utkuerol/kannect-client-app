package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.asus.example.R;
import com.example.asus.example.databinding.NavHeaderNavigationDrawerBinding;
import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.Subcategory;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemUserViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class Navigation_Drawer_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    GoogleSignInClient mGoogleSignInClient;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Build Google Sign in options
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        //get Sign in client
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        mDrawerLayout = findViewById(R.id.drawer_layout);

        final com.example.asus.example.databinding.ActivityNavigationDrawerBinding binding;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_navigation__drawer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_icon);

        final ItemUserViewModel itemUserViewModel = ViewModelProviders.of(this).get(ItemUserViewModel.class);
        itemUserViewModel.init(this.getApplicationContext());

        itemUserViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    View headerView = binding.navView.getHeaderView(0);
                    NavHeaderNavigationDrawerBinding headerBinding = NavHeaderNavigationDrawerBinding.bind(headerView);
                    headerBinding.setItemUserViewModel(itemUserViewModel);

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

        launchPersonalFeedFragment();
    }

    //method to sign out
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(i);
                        }
                    }
                });
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         //Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_feed) {
            launchPersonalFeedFragment();
            return true;
        } else if (id == R.id.nav_profile) {
            launchPersonalProfileFragment();
            return true;
        } else if (id == R.id.nav_groups) {
            launchGroupFragments();
            return true;
        } else if (id == R.id.nav_search) {
            launchSearchInputFragment();
            return true;
        } else if (id == R.id.nav_events) {
            launchEventFragments();
            return true;
        } else if (id == R.id.nav_logout) {
            signOut();
            return true;
        }


        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_feed) {
            launchPersonalFeedFragment();
        }  else if (id == R.id.nav_profile) {

            launchPersonalProfileFragment();
        } else if (id == R.id.nav_groups) {
            launchGroupFragments();
        } else if (id == R.id.nav_events) {
            launchEventFragments();
        } else if (id == R.id.nav_search) {
            launchSearchInputFragment();
        } else if (id == R.id.nav_logout) {
            signOut();
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

    public void launchUserProfileFragment(User user) {
        UserProfileFragment userProfileFragment = new UserProfileFragment();
        userProfileFragment.setUser(user);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, userProfileFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchPersonalProfileFragment() {
        PersonalProfileFragment personalProfileFragment = new PersonalProfileFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, personalProfileFragment);
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


    public void launchSearchResultFragments(String query) {


        UserSearchResultsFragment userSearchResultsFragment = new UserSearchResultsFragment();
        userSearchResultsFragment.setQuery(query);


        EventSearchResultsFragment eventSearchResultsFragment = new EventSearchResultsFragment();
        eventSearchResultsFragment.setQuery(query);


        GroupSearchResultsFragment groupSearchResultsFragment = new GroupSearchResultsFragment();
        groupSearchResultsFragment.setQuery(query);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        transaction.add(R.id.content_frame, userSearchResultsFragment);
        transaction.add(R.id.content_frame, eventSearchResultsFragment);
        transaction.add(R.id.content_frame, groupSearchResultsFragment);
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

    public void launchEventFeedFragment(Event event) {
        EventFeedFragment eventFeedFragment = new EventFeedFragment();
        eventFeedFragment.setEvent(event);
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

    public void launchEventInCategoryFragment(Category category) {
        EventsInCategoryFragment eventInCategoryFragment = new EventsInCategoryFragment();
        eventInCategoryFragment.setCategory(category);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, eventInCategoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchEventsInSubcategoryFragment(Subcategory subcategory) {
        EventsInSubcategoryFragment eventsInSubcategoryFragment = new EventsInSubcategoryFragment();
        eventsInSubcategoryFragment.setSubcategory(subcategory);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, eventsInSubcategoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchGroupFeedFragment(Group group) {
        GroupFeedFragment groupFeedFragment = new GroupFeedFragment();
        groupFeedFragment.setGroup(group);
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

    public void launchGroupsInCategoryFragment(Category category) {
        GroupsInCategoryFragment groupsInCategoryFragment = new GroupsInCategoryFragment();
        groupsInCategoryFragment.setCategory(category);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, groupsInCategoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchGroupsInSubcategoryFragment(Subcategory subcategory) {
        GroupsInSubcategoryFragment groupsInSubcategoryFragment = new GroupsInSubcategoryFragment();
        groupsInSubcategoryFragment.setSubcategory(subcategory);
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

    public void launchNewEventInCategoryFragment(Category category) {
        NewEventInCategoryFragment newEventInCategoryFragment = new NewEventInCategoryFragment();
        newEventInCategoryFragment.setCategory(category);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, newEventInCategoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchNewEventInSubategoryFragment(Subcategory subcategory) {
        NewEventInSubcategoryFragment newEventInSubategoryFragment = new NewEventInSubcategoryFragment();
        newEventInSubategoryFragment.setSubcategory(subcategory);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, newEventInSubategoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchNewEventPostFragment(Event event) {
        NewEventPostFragment newEventPostFragment = new NewEventPostFragment();
        newEventPostFragment.setEvent(event);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, newEventPostFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchNewGroupInCategoryFragment(Category category) {
        NewGroupInCategoryFragment newGroupInCategoryFragment = new NewGroupInCategoryFragment();
        newGroupInCategoryFragment.setCategory(category);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, newGroupInCategoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchNewGroupInSubcategoryFragment(Subcategory subcategory) {
        NewGroupInSubcategoryFragment newGroupInSubcategoryFragment = new NewGroupInSubcategoryFragment();
        newGroupInSubcategoryFragment.setSubcategory(subcategory);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, newGroupInSubcategoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchNewGroupPostFragment(Group group) {
        NewGroupPostFragment newGroupPostFragment = new NewGroupPostFragment();
        newGroupPostFragment.setGroup(group);
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
        Toast.makeText(this, "1", Toast.LENGTH_SHORT);

        SearchInputFragment searchInputFragment = new SearchInputFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, searchInputFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchShowPostFragment(Post post) {
        ShowPostFragment showPostFragment = new ShowPostFragment();
        showPostFragment.setPost(post);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, showPostFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchSubcategoriesEventAndEventsInCategoryFragment(Category category) {
        SubcategoriesEventFragment subcategoriesEventFragment = new SubcategoriesEventFragment();
        EventsInCategoryFragment eventsInCategoryFragment = new EventsInCategoryFragment();
        eventsInCategoryFragment.setCategory(category);
        subcategoriesEventFragment.setCategory(category);
        eventsInCategoryFragment.setCategory(category);
        subcategoriesEventFragment.setCategory(category);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, subcategoriesEventFragment);
        transaction.add(R.id.content_frame, eventsInCategoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchSubcategoriesGroupAndGroupsInCategoryFragment(Category category) {
        SubcategoriesGroupFragment subcategoriesGroupFragment = new SubcategoriesGroupFragment();
        GroupsInCategoryFragment groupsInCategoryFragment = new GroupsInCategoryFragment();
        groupsInCategoryFragment.setCategory(category);
        subcategoriesGroupFragment.setCategory(category);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, subcategoriesGroupFragment);
        transaction.add(R.id.content_frame, groupsInCategoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void launchSubscriptionsFragment(User user) {
        SubscriptionsFragment subscriptionsFragment = new SubscriptionsFragment();
        subscriptionsFragment.setUser(user);
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
