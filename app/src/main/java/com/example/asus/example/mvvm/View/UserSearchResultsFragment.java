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

import java.util.List;

public class UserSearchResultsFragment extends Fragment {

    //binding
    //view model


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //set binding
        //sets adapter
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        //find view model
        //viewmodel.observe(this) --- sync with adapter
    }


}
