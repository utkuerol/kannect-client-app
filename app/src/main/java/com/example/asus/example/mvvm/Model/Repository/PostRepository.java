package com.example.asus.example.mvvm.Model.Repository;

import com.example.asus.example.mvvm.Model.Entities.Comment;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.WebServices.ServiceAPI;
import com.example.asus.example.mvvm.Model.WebServices.ServiceGenerator;

import retrofit2.Call;

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
    public void createPost(Post post){}

    /**
     * Method to indicate to the server, that a Post was deleted. Sends a Post Object to the server
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param post which was deleted.
     */
    public void deletePost(Post post){}

    /**
     * Method to indicate to the server, that a Post was edited. Sends a Post Object to the server
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param post which was edited.
     */
    public void editPost(Post post){}

    /**
     * Method to indicate to the server, that a Post was liked by an User. Sends Post Object to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param post which was liked.
     */
    public void likePost(Post post) {}

    /**
     * Method to indicate to the server, that a Post was unliked by an User. Sends Post Object to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param post which was unliked.
     */
    public void unlikePost(Post post) {}

    /**
     * Method to indicate to the server, that a Post was commented by an User. Sends Comment Object to the server.
     * It uses the ServiceGenerator class to create a service via Retrofit2 with the help of the ServiceAPI.
     * @param comment created by the User.
     */
    public void commentPost(Comment comment) {}









}
