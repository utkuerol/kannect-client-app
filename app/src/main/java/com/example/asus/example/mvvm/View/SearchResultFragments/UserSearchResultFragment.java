package com.example.asus.example.mvvm.View.SearchResultFragments;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.ViewModel.SearchResultViewModel;

public class UserSearchResultFragment extends Fragment {

    //private UserSearchResultAdapter adapter;
    //private UserSearchResultFragmentBinding binding;

    //viewModel inject ?


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //set binding like:
        //binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_list, container, false);
        //set layoutmanager
        //set adapter like: adapter = new Adapter()
        //return binding.getRoot();
        return null;
    }

    //observes the live data and updates the data

    private void observeViewModel(SearchResultViewModel searchResultViewModel) {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        // find viewModel with viewModel provider and observe it
        // observeViewModel(viewModel);
    }


}
