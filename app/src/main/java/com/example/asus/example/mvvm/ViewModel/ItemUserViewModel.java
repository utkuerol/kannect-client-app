package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;


public class ItemUserViewModel extends ViewModel {

    //user
    //context

    public ItemUserViewModel(user, context) {

    }

    public void onItemClick(View view) {
        //context.startActivity(UserProfileActivity.launchDetail(view.getContext(), user));
    }


}
