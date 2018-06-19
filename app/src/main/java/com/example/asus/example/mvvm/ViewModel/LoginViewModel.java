package com.example.asus.example.mvvm.ViewModel;
import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.asus.example.mvvm.Interface.LoginResultCallBacks;
import com.example.asus.example.mvvm.Model.User;

public class LoginViewModel extends ViewModel {
    private User user;
    private LoginResultCallBacks loginResultCallBacks;

    public LoginViewModel(LoginResultCallBacks loginResultCallBacks) {
        this.loginResultCallBacks = loginResultCallBacks;
        this.user = new User();
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
               user.setEmail(editable.toString());
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
                user.setPassword(editable.toString());
            }
        };

    }
    public void onLoginClicked(View view){
        if (user.isValidData())
            loginResultCallBacks.onSuccess("Success");
        else loginResultCallBacks.onError("Failed");
    }
}
