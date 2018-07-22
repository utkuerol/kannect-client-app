package com.example.asus.example.mvvm.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.ViewModel.MenuViewModel;

public class MenuFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.activity_navigation__drawer_drawer, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        MenuViewModel menuViewModel = new MenuViewModel();
        return super.onOptionsItemSelected(item) && menuViewModel.invoke(item);
    }
}
