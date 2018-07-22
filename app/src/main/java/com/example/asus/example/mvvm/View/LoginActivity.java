package com.example.asus.example.mvvm.View;

import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.asus.example.databinding.FragmentPersonalFeedBinding;

import com.example.asus.example.R;
import com.example.asus.example.databinding.ActivityLoginBinding;
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

    LoginViewModel viewModel = new LoginViewModel();
    ActivityLoginBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_login);

    //Google sign in api Client
    GoogleSignInClient mGoogleSignInClient;
    FragmentPersonalFeedBinding p = DataBindingUtil.setContentView(this, R.layout.fragment_personal_feed);

    //Define Request code for Sign In
    private int RC_SIGN_IN = 6;
    //Sign in button Declaration
    SignInButton signInButton = binding.signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Bind views

        //Build Google Sign in options
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        //get Sign in client
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        //get currently signed in user returns null if there is no logged in user
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        //update ui
        updateUI(account);


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

            // Signed in successfully, show authenticated UI.
            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.

            updateUI(null);
        }
    }

    private void updateUI(GoogleSignInAccount account) {
        //Account is not null then user is logged in
        if (account != null) {
            MutableLiveData<User> user = viewModel.invoke(account);

            SharedPreferences myPrefs = getSharedPreferences("CurrentUser", 0);
            SharedPreferences.Editor prefsEditor;
            prefsEditor = myPrefs.edit();
            prefsEditor.putLong("CurrentUserId", user.getValue().getId());
            prefsEditor.commit();


            Intent i = new Intent(getApplicationContext(), PersonalFeedFragment.class);
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "Login Fehlgeschlagen", Toast.LENGTH_LONG).show();
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
}
