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

import com.example.asus.example.databinding.FragmentNewUserPostBinding;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemUserViewModel;

/**
 * activity for adding a new Post
 */
public class NewUserPostFragment extends Fragment implements View.OnClickListener {


    private Button button;
    private EditText description;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        //set viewmodel
        final ItemUserViewModel itemUserViewModel = ViewModelProviders.of(this).get(ItemUserViewModel.class);

        //set databinding
        final FragmentNewUserPostBinding fragmentNewPostBinding = FragmentNewUserPostBinding.inflate(inflater, parent, false);

        itemUserViewModel.init(this.getContext().getApplicationContext());

        itemUserViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    fragmentNewPostBinding.setItemUserViewModel(itemUserViewModel);
                } else {
                    Toast.makeText(getContext(), "Server Error", Toast.LENGTH_SHORT);
                }
            }
        });

        button = fragmentNewPostBinding.button;
        description = fragmentNewPostBinding.newUserPostET;
        return fragmentNewPostBinding.getRoot();
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
