package com.example.asus.example.mvvm.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.example.databinding.FragmentUserSearchInputBinding;

public class SearchInputFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        
        //set databinding
        FragmentUserSearchInputBinding fragmentUserSearchInputBinding = FragmentUserSearchInputBinding.inflate(inflater, parent, false);

        //TODO: observe livedata somehow

        return fragmentUserSearchInputBinding.getRoot();

    }

}
