package com.example.asus.example.mvvm.Model.WebServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class which generates a Service using the Retrofit2 library.
 */
public class ServiceGenerator {

    // better to store in Gradle String files
    private static final String BASE_URL = "https://10.0.2.2:8443/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
