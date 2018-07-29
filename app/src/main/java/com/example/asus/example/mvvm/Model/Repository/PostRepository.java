package com.example.asus.example.mvvm.Model.Repository;

import com.example.asus.example.mvvm.Model.Entities.Comment;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;
import com.example.asus.example.mvvm.Model.WebServices.ServiceAPI;
import com.example.asus.example.mvvm.Model.WebServices.ServiceGenerator;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Repository which handles all the requests from the Viewmodel, regarding Post requests.
 */
public class PostRepository {


    /**
     * Default Constructor
     */
    public PostRepository() {

    }


    /**
     * Method to indicate to the Server, that a new Post was created. Sends a Post Object to the server
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param post which was created .
     */
    public void createPost(Post post) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<Post> call = client.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    /**
     * Method to indicate to the server, that a Post was deleted. Sends a Post Object to the server
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param post which was deleted.
     */
    public void deletePost(Post post) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<Post> call = client.deletePost(post.getId());
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }



    /**
     * Method to indicate to the server, that a Post was liked by an User. Sends Post Object to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param post which was liked.
     */
    public void likePost(Post post, User user) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<ResponseBody> call = client.likePost(post, user);
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
     * Method to indicate to the server, that a Post was unliked by an User. Sends Post Object to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param post which was unliked.
     */
    public void unlikePost(Post post, User user) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<ResponseBody> call = client.unlikePost(post, user);
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
     * Method to indicate to the server, that a Post was commented by an User. Sends Comment Object to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param comment created by the User.
     */
    public void commentPost(Comment comment) {
        ServiceAPI client = ServiceGenerator.createService(ServiceAPI.class);
        Call<Comment> call = client.commentPost(comment);
        call.enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(Call<Comment> call, Response<Comment> response) {

            }

            @Override
            public void onFailure(Call<Comment> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
