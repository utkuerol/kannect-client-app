package com.example.asus.example.mvvm.ViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.asus.example.mvvm.Model.User;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<User> user;

    public LoginViewModel(){
        this.user = new MutableLiveData();
        this.user.setValue(new User());
    }


    public LiveData<User> getUser() {
        return user;
    }


    public TextWatcher getEmailTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                user.getValue().setEmail(editable.toString());
            }
        };

    }



    public TextWatcher getPasswordTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                user.getValue().setPassword(editable.toString());
            }
        };

    }

    public void onLoginClicked(View view){

        user.postValue(new User(user.getValue().getEmail()+"3", getUser().getValue().getPassword()));
    }
}
