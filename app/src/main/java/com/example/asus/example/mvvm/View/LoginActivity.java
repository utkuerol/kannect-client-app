package com.example.asus.example.mvvm.View;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.Model.Entities.User;


import com.example.asus.example.mvvm.Model.Repository.AccountRepository;
import com.example.asus.example.mvvm.ViewModel.LoginViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.sun.xml.internal.ws.api.databinding.Databinding;


public class LoginActivity extends AppCompatActivity {

    LoginViewModel viewModel = new LoginViewModel();
    Databinding binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
    GoogleSignInClient mGoogleSignInClient;
    GoogleSignInAccount account;


    @Override protected void onCreate(Bundle savedInstanceState) {
        // set binding
        // get and set user from intent

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel.invoke(binding.Email,binding.pass);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient= GoogleSignIn.getClient(this, gso);

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

    /**
     * redirects to this activity
     * @param context needed Application Information to launch this Activity.
     * @return the Intent, which is used to redirect to this Activity.
     */
    public static Intent launchDetail(Context context, User user) {
        // redirects from parameter context to this activity, takes user as parameter
        return null;
    }


    /**
     * Method allowing the user to signin
     */
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    /**
     * handles the Task from the GoogleSignInAccount
     *
     * @param completedTask Google Task API
     */
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            account  = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.


            //invoke the VM
            viewModel.invoke(account);


        } catch (ApiException e) {

        }
    }
}
