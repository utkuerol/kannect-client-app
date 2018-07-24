package com.example.asus.example.mvvm.Model.WebServices;


import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Comment;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ServiceAPI {


    /**
     * service to find Events with a given search query
     * @param searchQuery search Query the User typed in
     * @return List of all the Events which match the search Query as a Response Object
     */
    @GET("/events")
    Call<List<Event>> getSearchEvents(String searchQuery);

    /**
     * service to create an Event
     * @param event to be created
     * @return void, no response needed
     */
    @POST("/create")
    Call<Event> createEvent(@Body Event event);

    /**
     * service to delete a given event
     * @param eventID event to be deleted
     * @return void, no response needed
     */
    @DELETE("/delete")
    Call<Event> deleteEvent(long eventID);


    /**
     * service to find Groups by given search suery
     * @param searchQuery search query the User typed in
     * @return List of Groups which match the search query as a Response Object
     */
    @GET("/groups")
    Call<List<Group>> getSearchGroups(String searchQuery);

    /**
     * service to create a Group
     * @param group to be created
     * @return void, no response needed
     */
    @POST("/createGroup")
    Call<Group> createGroup(@Body Group group);

    /**
     * service to delete a Group
     * @param groupID group to be deleted
     * @return void, no response needed
     */
    @DELETE("/deleteGroup")
    Call<Group> deleteGroup(long groupID);


    /**
     * service to get all Posts for a Users feed
     * @param userID user which Feed is asked for
     * @return List of all Posts for the Users feed as a Response object
     */
    @GET("/personalFeed")
    Call<List<Post>> getPersonalFeed(long userID);

    /**
     * service to get all Posts for a Groups feed
     * @param groupID group which Feed is asked for
     * @return List of all Posts for the Groups feed as a Response Object
     */
    @GET("/groupFeed")
    Call<List<Post>> getGroupFeed(long groupID);

    /**
     * service to get all Posts for a Events feed
     * @param eventID event which feed is asked for
     * @return List of all Posts for the Groups as a Response Object
     */
    @GET("/eventFeed")
    Call<List<Post>>  getEventFeed(long eventID);

    /**
     * service to save a new Post in the server
     * @param post to be saved
     * @return void, no response needed
     */
    @POST("/post")
    Call<Post> createPost(@Body Post post);

    /**
     * service to delete an existing Post
     * @param postID post to be deleted
     * @return void, no response needed
     */
    @DELETE("/deletePost")
    Call<Post> deletePost(long postID);


    /**
     * service to like a Post
     * @param post which was liked
     * @param user which liked the Post
     * @return void, no response needed
     */
    @Multipart
    @POST("/likePost")
    Call<ResponseBody> likePost(@Part Post post, @Part User user);

    /**
     * service to indicate that User unliked a Post
     * @param post which was unliked
     * @param user which unliked a Post
     * @return void, no response needed
     */
    @Multipart
    @POST("/unlikePost")
    Call<ResponseBody> unlikePost(@Part Post post, @Part User user);

    /**
     * service to comment a Post
     * @param comment by the user
     * @return void, no response needed
     */

    @POST("/commentPost")
    Call<Comment> commentPost(@Body Comment comment);

    /**
     * service to get Users by a given Search Query of a User
     * @param searchQuery typed in by the user
     * @return List of all the Users, who match the search query as a Response object
     */
    @GET("/users")
    Call<List<User>> getSearchUsers(String searchQuery);

    /**
     * service to indicate to the server that a user subscribed to another user
     * @param subscriber User who subscribed another user
     * @param subscribed User who was subscribed
     * @return void, no response needed
     */
    @Multipart
    @POST("/subscribe")
    Call<ResponseBody> subscribeUser(@Part User subscriber, @Part User subscribed);

    /**
     * service to indicate to the server that a user unsubscribed to another user
     * @param subscriber User who unsubscribed another user
     * @param subscribed User who was unsubscribed
     * @return void, no response needed
     */
    @Multipart
    @POST("/unsubscribe")
    Call<ResponseBody> unsubscribeUser(@Part User subscriber, @Part User subscribed);

    /**
     * service to indicate to the server that a user joint a group
     * @param user who joined a group
     * @param group which was joined by the user
     * @return void, no response needed
     */
    @Multipart
    @POST("/joinGroup")
    Call<ResponseBody> joinGroup(@Part User user, @Part Group group);

    /**
     * service to indicate to the server that a user left a group
     * @param user who left a group
     * @param group which was left by the user
     * @return void, no response needed
     */
    @Multipart
    @POST("/leaveGroup")
    Call<ResponseBody> leaveGroup(@Part User user, @Part Group group);

    /**
     * service to indicate to the server that a user wants to participate in an Event
     * @param user wants to participate in the event
     * @param event which the user wants to participate in
     * @return void, no response needed
     */
    @Multipart
    @POST("/participateInEvent")
    Call<ResponseBody> participateInEvent(@Part User user, @Part Event event);

    /**
     * service to indicate to the server that a user wants to leave an Event
     * @param user wants to leave in the event
     * @param event which the user wants to leave
     * @return void, no response needed
     */
    @Multipart
    @POST("/leaveEvent")
    Call<ResponseBody> leaveEvent(@Part User user, @Part Event event);

    /**
     * service to get Categories by given search query
     * @param searchQuery typed in by the user
     * @return List of Categories which match the search query as a Call object
     */
    @GET("/categories")
    Call<List<Category>> getCategories(String searchQuery);


    /**
     * service to get a user by mail
     *
     * @param userMail
     * @return User By Mail
     */
    @GET("userByMail")
    Call<User> getUserByMail(@Query("userMail") String userMail);

    /**
     * @param user
     * @return
     */
    @POST("createUser")
    Call<ResponseBody> createUser(@Body User user);

    /**
     * service to get a User by his id
     *
     * @param userId of the user
     * @return user which matched the id
     */
    @GET("/userById")
    Call<User> getUserByID(@Query(value = "userId") long userId);

    /**
     * service to get the feed of a user by his id
     *
     * @param userID id of user whose feed will be generated
     * @return list of posts for the feed of the user
     */
    @GET("/userProfile")
    Call<List<Post>> getUserProfile(long userID);

}
