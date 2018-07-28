package com.example.asus.example.mvvm.Model.Repository;


import android.arch.lifecycle.MutableLiveData;

import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.WebServices.ServiceAPI;
import com.example.asus.example.mvvm.Model.WebServices.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Repository which handles all the requests from the Viewmodel, regarding Category requests.
 */
public class CategoryRepository {


    /**
     * Default Constructor
     */
    public CategoryRepository() {


    }


    /**
     * Method to get all the Category from the server, which match the search query.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @return a List of all the found Categories from the server as a MutableLiveData object
     */
    public MutableLiveData<List<Category>> getCategories() {

    ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<List<Category>> call = client.getCategories();
    final MutableLiveData<List<Category>> result = new MutableLiveData<>();

    call.enqueue(new Callback<List<Category>>() {
        @Override
        public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
            if (response.isSuccessful()) {
                result.setValue(response.body());
            }
        }


        @Override
        public void onFailure(Call<List<Category>> call, Throwable t) {

            t.printStackTrace();
        }
    });

        return result;


    }


}
