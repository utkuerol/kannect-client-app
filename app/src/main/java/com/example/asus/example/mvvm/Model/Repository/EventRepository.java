package com.example.asus.example.mvvm.Model.Repository;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.WebServices.ServiceAPI;
import com.example.asus.example.mvvm.Model.WebServices.ServiceGenerator;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Repository which handles all the requests from the Viewmodel, regarding Event requests.
 */
public class EventRepository {

    /**
     * Default Constructor
     */
    public EventRepository() {

    }


    /**
     * Method to get all the Events from the server, which match the search query.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param searchQuery typed in by user
     * @return List of all the Events which match the search query as a MutableLiveData object
     */
    public MutableLiveData<List<Event>> getEvents(String searchQuery) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<List<Event>> call = client.getSearchEvents(searchQuery);
        final MutableLiveData<List<Event>> result = new MutableLiveData<>();

        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                result.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return result;
    }


    /**
     * Method to notify Server that an Event was created. This Method transfers an Event object to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param event created Event
     */
    public void createEvent(Event event) {

        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<Event> call = client.createEvent(event);
        call.enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {
                Log.d("debug", "on response create event");
                if (!response.isSuccessful()) {
                    Log.d("debug", "create event response fail");
                }
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    /**
     * Method to notify Server that an existing Event was deleted. This Method transfers the Event object to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param event which will be deleted
     */
    public void deleteEvent(Event event) {

        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<Event> call = client.deleteEvent(event);
        call.enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {

            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


    /**
     * Method to indicate to the Server, that a User wants to participate in an Event. Sends a User and a Event object to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     *
     * @param user  who wants to participate in an Event.
     * @param event in which the User wants to participate in.
     */
    public void participateEvent(User user, Event event) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<ResponseBody> call = client.participateInEvent(user, event);
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
     * Method to indicate to the Server, that a User doesn´t want to participate in an Event anymore. Sends a User and an Event Object to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     *
     * @param user  who wants to leave an Event
     * @param event which the User wants to leave.
     */
    public void leaveEvent(User user, Event event) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<ResponseBody> call = client.leaveEvent(user, event);
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


}
