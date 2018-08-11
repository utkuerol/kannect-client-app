package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.ViewModel.LoginViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class LoginActivity extends AppCompatActivity {

    /*
     * ViewModel for the activity Login
     */
    LoginViewModel viewModel;


    /*
     *  Google sign in api Client
     */
    GoogleSignInClient mGoogleSignInClient;
    /*
     * Sign in button Declaration
     */
    SignInButton signInButton;
    /*
     * Google SignIn Account Declaration
     */
    GoogleSignInAccount account;

    User user = new User();

    /*
     * Define Request code for Sign In
     */
    private int RC_SIGN_IN = 6;

    /*
     * onCreate create the activity and proceed the process of Loging In , first of all it checks if there is a user logged ,
     * if not then a View with a Sign In button will be displayed
     * after a successful Login the user will be redirected to the main Activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signInButton = findViewById(R.id.sign_in_button);

        //Bind views

        //Build Google Sign in options
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        //get Sign in client
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // get currently signed in user
        // returns null if there is no logged in user
        account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            user.setEmail(account.getEmail());
            user.setName(account.getDisplayName());
            user.setImageUrl(account.getPhotoUrl() != null ? account.getPhotoUrl().toString() : null);
        }

        // setting the ViewModel
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        // saving the logged user in the shared preferences
        viewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    SharedPreferences myPrefs = getSharedPreferences("CurrentUser", 0);
                    SharedPreferences.Editor prefsEditor;
                    prefsEditor = myPrefs.edit();
                    prefsEditor.putInt("CurrentUserId", user.getId());
                    prefsEditor.apply();
                }
            }
        });

        updateUI(user);


    }

    //Method to signIn
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    //method to sign out
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            updateUI(null);
                        }
                    }
                });
    }

    //Handle sign in results
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {

            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            user.setEmail(account.getEmail());
            user.setName(account.getDisplayName());
            user.setImageUrl(account.getPhotoUrl() != null ? account.getPhotoUrl().toString() : null);
            // Signed in successfully, show authenticated UI.
            updateUI(user);
        } catch (ApiException e) {

            // The ApiException status code indicates the detailed failure reason.

        }
    }

    /*
     *
     * sends the logged user to the server to test if he is a new user or not
     * if the logged user is new then a new account will be created
     * else the user will be redirected to MainActivity (his personalfeed)
     *
     */
    private void updateUI(final User user) {
        //Account is not null then user is logged in
        if (user.getEmail() != null) {
            viewModel.invoke(user).observe(this, new Observer<User>() {
                @Override
                public void onChanged(@Nullable final User user) {
                    if (user == null) {
                        viewModel.createUser(LoginActivity.this.user).observe(LoginActivity.this, new Observer<Boolean>() {
                            @Override
                            public void onChanged(@Nullable Boolean aBoolean) {
                                if (aBoolean) {
                                    updateUI(user);
                                }
                            }
                        });
                    } else {
                        viewModel.setUser(viewModel.invoke(user));
                        SharedPreferences myPrefs = getSharedPreferences("CurrentUser", 0);
                        SharedPreferences.Editor prefsEditor;
                        prefsEditor = myPrefs.edit();
                        prefsEditor.putInt("CurrentUserId", user.getId());
                        prefsEditor.commit();
                        Intent i = new Intent(getApplicationContext(), Navigation_Drawer_Activity.class);
                        finish();
                        startActivity(i);
                    }
                }
            });

        } else {
            Toast.makeText(getApplicationContext(), "no Login", Toast.LENGTH_LONG).show();
            signInButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    signIn();
                }
            });
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LoginViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(LoginViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
