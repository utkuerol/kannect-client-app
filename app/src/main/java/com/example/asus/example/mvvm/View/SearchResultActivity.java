package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.SearchResultFragments.UserSearchResultFragment;
import com.example.asus.example.mvvm.ViewModel.SearchResultViewModel;

import java.util.List;

public class SearchResultActivity extends AppCompatActivity {

    private SearchResultViewModel mSearchResultViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add project list fragment if this is first creation
        if (savedInstanceState == null) {
            UserSearchResultFragment fragment = new UserSearchResultFragment();

            //getSupportFragmentManager().beginTransaction()
                  //  .add(R.id.fragment_container, fragment, ProjectListFragment.TAG).commit();
        }
    }

    /** Shows the user fragment */
    public void showUser(MutableLiveData<User> mUser) {

        UserFragment userFragment = new UserFragment(mUser);

        //start fragment
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("project")
                .replace(R.id.fragment_container,
                        projectFragment, null).commit();
         item_layoutBinding binding = DataBindingUtil.setContentView();
    }
}
