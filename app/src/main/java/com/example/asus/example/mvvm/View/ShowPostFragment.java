package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asus.example.R;
import com.example.asus.example.databinding.FragmentShowPostBinding;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.ItemPostViewModel;

/**
 * Activity class for the view regarding showing a Post and its comments.
 * Uses the ItemPostViewModel as its ViewModel.
 */
public class ShowPostFragment extends Fragment implements View.OnClickListener {

    private FragmentShowPostBinding fragmentShowPostBinding;
    private ItemPostViewModel itemPostViewModel;
    private Post post;


    /**
     * Method which will be called when this fragment is created.
     * Inflates the View, sets the ViewModel and the Adapter with the right onClickListener for the
     * RecyclerView.
     * Observes getCurrentUser to check if there is a value or a null object.
     * Initializes the deleteButton.
     * @param inflater           inflates the layout on the screen
     * @param parent             of this ViewGroup
     * @param savedInstanceState state of the Application as a Bundle
     * @return the outermost View in the layout file associated with the Binding.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        fragmentShowPostBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_show_post, parent, false);

        //set viewmodel
        itemPostViewModel = ViewModelProviders.of(this).get(ItemPostViewModel.class);

        //set databinding


        //set adapter for comments recycler view (if we implement this feature eventually)

        itemPostViewModel.init(post, this.getContext().getApplicationContext());

        itemPostViewModel.getCurrentUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    fragmentShowPostBinding.setItemPostViewModel(itemPostViewModel);
                } else {
                    Toast.makeText(getContext(), "Server Error", Toast.LENGTH_SHORT);
                }
            }
        });
        ImageView deleteView = (ImageView) fragmentShowPostBinding.imageView2;
        deleteView.setOnClickListener(this);

        return fragmentShowPostBinding.getRoot();
    }

    /**
     * Method which will be called, when a view from this Fragment was clicked on.
     * In this case the deleteButton.
     * @param v view which was clicked on.
     */
    @Override
    public void onClick(View v) {
        Navigation_Drawer_Activity navigation_drawer_activity = (Navigation_Drawer_Activity) getActivity();

        switch (v.getId()) {
            case R.id.imageView2:
                itemPostViewModel.deletePost();
        }
    }

    /**
     * sets the post which was clicked on by user and is displayed in this Fragment.
     * @param post that clicked on by user.
     */
    public void setPost(Post post) {
        this.post = post;
    }

}
