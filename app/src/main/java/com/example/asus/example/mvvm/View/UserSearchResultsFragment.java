package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.View.SearchResultFragments.UserSearchResultFragment;
import com.example.asus.example.mvvm.ViewModel.SearchResultViewModel;
import com.example.asus.example.mvvm.ViewModel.UserViewModel;

import java.util.List;

/**
 * Fragment for the view, to show all users which match the search query.
 */
public class UserSearchResultsFragment extends Fragment {

    UserViewModel viewModel;


    /**
     * Method which will be called when the view is created.
     * Sets the Adapter for the recycler View.
     * Sets the DataBinding to set/receive Data to/from the Layout.
     * @param view returned by onCreateView(LayoutInflater, ViewGroup, Bundle).
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    }

    /**
     * Called when the Fragments activity has been create and this fragments view hierarchy instantiated.
     * finds the correct View Model and makes it observe this Fragment, to sync with adapter.
     * @param savedInstanceState If the fragment is being re-created from a previous saved state, this is the state.
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    }


}
