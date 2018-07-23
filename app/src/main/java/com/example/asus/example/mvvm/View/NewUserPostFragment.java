package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.mvvm.ViewModel.ItemUserViewModel;

/**
 * activity for adding a new Post
 */
public class NewUserPostFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        //set viewmodel
        ItemUserViewModel itemUserViewModel = ViewModelProviders.of(this).get(ItemUserViewModel.class);

        //TODO: missing layouts cant implement further
        //set databinding

        return getView();
    }

}
