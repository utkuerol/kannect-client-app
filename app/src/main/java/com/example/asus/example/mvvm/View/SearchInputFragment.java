package com.example.asus.example.mvvm.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentUserSearchInputBinding;

public class SearchInputFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        //set databinding
        FragmentUserSearchInputBinding fragmentUserSearchInputBinding = FragmentUserSearchInputBinding.inflate(inflater, parent, false);

        //TODO: observe livedata somehow
        Toast.makeText(getContext(), "In Event Fragment", Toast.LENGTH_LONG).show();

        View v = inflater.inflate(R.layout.fragment_user_search_input, parent, false);


        ////////////////////////
        Button b = (Button) v.findViewById(R.id.uhar);
        b.setOnClickListener(this);
        ///////////////////////


        return v;
    }

    public void launchFragment() {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
        navigation_drawer_activity.launchCategoriesEventFragment();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.uhar:
                launchFragment();
                break;
        }
    }

}
