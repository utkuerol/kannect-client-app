package com.example.asus.example.mvvm.View;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentUserSearchInputBinding;

public class SearchInputFragment extends Fragment implements View.OnClickListener {
    FragmentUserSearchInputBinding fragmentUserSearchInputBinding;
    private String query;

    public String getQuery() {
        return query;
    }

    /**
     * Method which will be called when this fragment is created.
     * Inflates the View.
     * Sets onClickListener for the userSearchInputButton.
     * @param inflater           inflates the layout on the screen
     * @param parent             of this ViewGroup
     * @param savedInstanceState state of the Application as a Bundle
     * @return the outermost View in the layout file associated with the Binding.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        //set databinding
        fragmentUserSearchInputBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_user_search_input, parent, false);


        Button b = (Button) fragmentUserSearchInputBinding.userSearchInputButton;
        b.setOnClickListener(this);

        return fragmentUserSearchInputBinding.getRoot();
    }


    /**
     * Method which will be called, when user clicks on userSearchInputButton.
     * Launches the Search ResultFragments with the query, which was typed in by user.
     * @param v view which was clicked on
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.userSearchInputButton:

                this.query = fragmentUserSearchInputBinding.userSearchInputET.getText().toString();

                Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();
                navigation_drawer_activity.launchSearchResultFragments(query);
        }
    }

}
