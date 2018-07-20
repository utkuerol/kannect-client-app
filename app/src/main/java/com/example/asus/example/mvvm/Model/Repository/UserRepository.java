package com.example.asus.example.mvvm.Model.Repository;

import android.arch.lifecycle.MutableLiveData;

import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.WebServices.ServiceAPI;
import com.example.asus.example.mvvm.Model.WebServices.ServiceGenerator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Repository which handles all the requests from the Viewmodel, User Message requests.
 */
public class UserRepository {

    /**
     * Default Constructor.
     */
    public UserRepository() {

    }
    /**
     * Method to get all User, from the server, which match the Search Query. Sends Search Query to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param searchQuery typed in by User.
     * @return List of Users, which match the Search Query, as a MutableLiveData object.
     */
    public MutableLiveData<List<User>> getUsers(String searchQuery) {
        final MutableLiveData<List<User>> result = new MutableLiveData<>();
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<List<User>> call = client.getSearchUsers(searchQuery);
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return result;
    }

    /**
     * Method to indicate to the server, that a User subscribed to another User. Sends two User objects to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param subscriber User who subscribed another User.
     * @param subscribed User who was subscribed to.
     */
    public void subscribeUser(User subscriber, User subscribed) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<ResponseBody> call = client.subscribeUser(subscriber, subscribed);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    /**
     * Method to indicate to the server, that a User unsubscribed to another User. Sends two User object to the Server
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param subscriber User who unsubscribed to another User.
     * @param subscribed User who was unsubscribed to.
     */
    public void unsubscribeUser(User subscriber, User subscribed) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<ResponseBody> call = client.unsubscribeUser(subscriber, subscribed);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    public MutableLiveData<User> loginUser(GoogleSignInAccount account) {
        final MutableLiveData<User> result = new MutableLiveData<>();


        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);

        Call<User> call = client.getLoginUser(account.getDisplayName(), account.getEmail(), account.getPhotoUrl().toString(), account.getId());
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
            }
        });


        return result;
    }

}
