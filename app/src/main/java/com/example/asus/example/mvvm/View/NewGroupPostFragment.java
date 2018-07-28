package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asus.example.databinding.FragmentNewGroupPostBinding;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemGroupViewModel;

//TODO change layout names
public class NewGroupPostFragment extends Fragment {


    private Group group;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        //set databinding
        final FragmentNewGroupPostBinding fragmentNewPostBinding = FragmentNewGroupPostBinding.inflate(inflater, parent, false);

        //set viewmodel
        final ItemGroupViewModel itemGroupViewModel = ViewModelProviders.of(this).get(ItemGroupViewModel.class);

        itemGroupViewModel.init(group, this.getContext().getApplicationContext());

        itemGroupViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    fragmentNewPostBinding.setItemGroupViewModel(itemGroupViewModel);
                } else {
                    Toast.makeText(getContext(), "Server Error", Toast.LENGTH_SHORT);
                }
            }
        });

        return fragmentNewPostBinding.getRoot();

    }


    public void setGroup(Group group) {
        this.group = group;
    }

}
