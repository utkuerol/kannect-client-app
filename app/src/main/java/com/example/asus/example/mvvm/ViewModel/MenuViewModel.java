package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.ViewModel;

import com.example.asus.example.R;

import java.awt.MenuItem;

public class MenuViewModel extends ViewModel {

    public boolean invoke(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.personal_feed:
                showPersonalFeed();
                return true;
            case R.id.messages:
                showMessages();
                return true;
            case R.id.groups:
                showGroups();
                return true;
            case R.id.events:
                showEvents();
                return true;
            case R.id.subscriptions:
                showSubscriptions();
                return true;
            default:
                return false;

        }
    }

    private void showSubscriptions() {
    }

    private void showEvents() {
    }

    private void showGroups() {
    }

    private void showPersonalFeed() {
    }

    private void showMessages() {
    }


}