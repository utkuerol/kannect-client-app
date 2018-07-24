package com.example.asus.example.mvvm.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.WebServices.ServiceAPI;
import com.example.asus.example.mvvm.Model.WebServices.ServiceGenerator;
import com.example.asus.example.mvvm.ViewModel.LoginViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    LoginViewModel viewModel = new LoginViewModel();


    //Google sign in api Client
    GoogleSignInClient mGoogleSignInClient;

    //Define Request code for Sign In
    private int RC_SIGN_IN = 6;
    //Sign in button Declaration
    SignInButton signInButton;

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

            viewModel.invoke(account);
            Call<User> call = getApi().getUserByMail(account.getEmail());

            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (!response.isSuccessful()) {
                        Log.d("debug", "response fail");
                    } else {
                        Log.d("debug", "response success");
                        User user = response.body();
                        Log.d("debug", "response null " + (response.body() == null));
                        SharedPreferences myPrefs = getSharedPreferences("CurrentUser", 0);
                        SharedPreferences.Editor prefsEditor;
                        prefsEditor = myPrefs.edit();
                        prefsEditor.putInt("CurrentUserId", user.getId());
                        prefsEditor.commit();
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.d("debug", t.getMessage());
                }
            });

            Intent i = new Intent(getApplicationContext(), Navigation_Drawer_Activity.class);
            startActivity(i);
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

    public ServiceAPI getApi() {
        return ServiceGenerator.getRetrofitInstance().create(ServiceAPI.class);
    }
}
