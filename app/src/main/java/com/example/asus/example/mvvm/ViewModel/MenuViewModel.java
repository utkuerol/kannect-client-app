package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.ViewModel;
import android.view.MenuItem;


public class MenuViewModel extends ViewModel {

    /**
     * retrieve the item which was selected by the user and invoke the show actions
     *
     * @param item
     * @return
     */
    public boolean invoke(MenuItem item) {
        /*switch (item.getItemId()) {
            case R.id.personal_feed:
                showPersonalFeed();
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
            default:*/
                return false;

        }


    /**
     * shows the subscriptions
     */
    private void showSubscriptions() {
    }

    /**
     * shows the event feed
     */
    private void showEvents() {
    }

    /**
     * shows the group feed
     */
    private void showGroups() {
    }

    /**
     * shows the personal feed
     */
    private void showPersonalFeed() {
    }

    /**
     * shows all messages
     */
    private void showMessages() {
    }


}