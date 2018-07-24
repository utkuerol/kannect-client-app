package com.example.asus.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.Repository.UserRepository;
import com.example.asus.example.mvvm.Model.WebServices.ServiceAPI;
import com.example.asus.example.mvvm.Model.WebServices.ServiceGenerator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ViewModel class for login, that is responsible for preparing and managing the data for Views
 * regarding login functions, by handling the communication of the View with the
 * UserRepository class, which has the user/account business logic of the application.
 * Objects received from repositories will be stored as MutableLiveData Objects.
 */
public class LoginViewModel extends ViewModel {

    private MutableLiveData<User> user = new MutableLiveData();
    private UserRepository userRepository = new UserRepository();

    /**
     * Invokes the chains of events, leading to user login.
     *
     * @param account google sign in account.
     */
    public void invoke(GoogleSignInAccount account) {
            User u = new User();
            u.setEmail(account.getEmail());
            u.setImageUrl(account.getPhotoUrl().toString());
            u.setName(account.getDisplayName());
            user.setValue(u);
        Call<ResponseBody> call = getApi().createUser(u);
        Log.d("debug", "invoke");

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("debug", "succesfull" + (response.isSuccessful()));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("debug", "fail");

            }
        });

    }

    public void getUserByMail(GoogleSignInAccount account) {
        userRepository.findByEmail(account.getEmail());
    }


    /**
     * Gets the user, which is logging in.
     *
     * @return observable user.
     */
    public MutableLiveData<User> getUser() {
        return user;
    }

    public void setUser(MutableLiveData<User> user) {
        this.user = user;
    }

    public ServiceAPI getApi() {
        return ServiceGenerator.getRetrofitInstance().create(ServiceAPI.class);
    }
}
