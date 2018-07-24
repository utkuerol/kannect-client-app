package com.example.asus.example.mvvm.Model.WebServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class which generates a Service using the Retrofit2 library.
 */
public class ServiceGenerator {

    // better to store in Gradle String files
    private static final String BASE_URL = "https://10.0.2.2:8443/";


    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    /**
     * Create an implementation of the API endpoints defined by the service interface.
     * @param serviceClass service Interface class
     * @param <S> service Interface class
     * @return implementation of the API endpoints defined by the service interface.
     */
    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

    //Todo weg machen
    // kann man in repo so aufrufen
    // ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
}
