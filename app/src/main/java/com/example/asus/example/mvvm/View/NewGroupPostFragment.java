package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.example.databinding.FragmentNewGroupPostBinding;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemGroupViewModel;

//TODO change layout names
public class NewGroupPostFragment extends Fragment implements View.OnClickListener {


    private Group group;
    private Button button;
    private EditText description;
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
                }
            }
        });

        button = fragmentNewPostBinding.button;
        button.setOnClickListener(this);
        description = fragmentNewPostBinding.newGroupPostET;
        return fragmentNewPostBinding.getRoot();

    }


    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == button.getId()) {
            if (description.getText().toString().length() == 0) {
                Toast.makeText(this.getContext(), "You can´t create a post without Text!",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
