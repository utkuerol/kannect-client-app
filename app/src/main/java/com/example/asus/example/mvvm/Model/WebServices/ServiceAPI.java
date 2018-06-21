package com.example.asus.example.mvvm.Model.WebServices;



import com.example.asus.example.mvvm.Model.Entities.Comment;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Message;
import com.example.asus.example.mvvm.Model.Entities.Post;
import com.example.asus.example.mvvm.Model.Entities.User;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

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
    Call<Void> createEvent(@Body Event event);

    /**
     * service to delete a given event
     * @param event event to be deleted
     * @return void, no response needed
     */
    @DELETE("/delete")
    Call<Void> deleteEvent(@Body Event event);

    /**
     * service to edit an existing event
     * @param editedEvent  edited Event
     * @param eventToEdit Event which will be replaced by the edited Event
     * @return void, no response needed
     */
    @POST("/edit")
    Call<Void> editEvent(@Body Event editedEvent, @Body Event eventToEdit);

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
    Call<Void> createGroup(@Body Group group);

    /**
     * service to delete a Group
     * @param group to be deleted
     * @return void, no response needed
     */
    @DELETE("/deleteGroup")
    Call<Void> deleteGroup(@Body Group group);

    /**
     * service to edit a Group
     * @param editedGroup the edited Group
     * @param groupToEdit group which will be replaced by edited Group
     * @return void, no response needed
     */
    @POST("/editGroup")
    Call<Void> editGroup(@Body Group editedGroup, @Body Group groupToEdit);

    /**
     * service to get all received messages
     * @param user of which all received message are asked for
     * @return List of all received Messages as a Response Object
     */
    @GET("/receivedMessages")
    Call<List<Message>> getReceivedMessages(@Body User user);

    /**
     * service to to get all sent Messages by a user
     * @param user of which all sent Messages are asked for
     * @return List of all sent Messages as a Repsonse Object
     */
    @GET("/sentMessages")
    Call<List<Message>> getSentMessages(@Body User user);

    /**
     * service to send  a message
     * @param message Message which will be send
     * @return void, no response needed
     */
    @POST("/sendMessage")
    Call<Void> sendMessage(@Body Message message);

    /**
     * service to get all Posts for a Users feed
     * @param user which Feed is asked for
     * @return List of all Posts for the Users feed as a Response object
     */
    @GET("/personalFeed")
    Call<List<Post>> getPersonalFeed(@Body User user);

    /**
     * service to get all Posts for a Groups feed
     * @param group which Feed is asked for
     * @return List of all Posts for the Groups feed as a Response Object
     */
    @GET("/groupFeed")
    Call<List<Post>> getGroupFeed(@Body Group group);

    /**
     * service to get all Posts for a Events feed
     * @param event which feed is asked for
     * @return List of all Posts for the Groups as a Response Object
     */
    @GET("/eventFeed")
    Call<List<Post>>  getEventFeed(@Body Event event);

    /**
     * service to save a new Post in the server
     * @param post to be saved
     * @return void, no response needed
     */
    @POST("/post")
    Call<Void> createPost(@Body Post post);

    /**
     * service to delete an existing Post
     * @param post to be deleted
     * @return void, no response needed
     */
    @DELETE("/deletePost")
    Call<Void> deletePost(@Body Post post);

    /**
     * service to edit an existing Post
     * @param editedPost Post with wanted changes
     * @param postToEdit Post will be replaced by edited Post
     * @return void, no response needed
     */
    @POST("/editPost")
    Call<Void>  editPost(@Body Post editedPost, @Body Post postToEdit);

    /**
     * service to like a Post
     * @param post which was liked
     * @param user which liked the Post
     * @return void, no response needed
     */
    @POST("/likePost")
    Call<Void> likePost(@Body Post post, @Body User user);

    /**
     * service to indicate that Userr unliked a Post
     * @param post which was unliked
     * @param user which unliked a Post
     * @return void, no response needed
     */
    @POST("/unlikePost")
    Call<Void> unlikePost(@Body Post post, @Body User user);

    /**
     * service to comment a Post
     * @param post which was commented by user
     * @param user user which commented a post
     * @param comment by the user
     * @return void, no response needed
     */
    @POST("/commentPost")
    Call<Void> commentPost(@Body Post post, @Body User user, @Body Comment comment);

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
    @POST("/subscribe")
    Call<Void> subscribeUser(@Body User subscriber, @Body User subscribed);

    /**
     * service to indicate to the server that a user unsubscribed to another user
     * @param subscriber User who unsubscribed another user
     * @param subscribed User who was unsubscribed
     * @return void, no response needed
     */
    @POST("/unsubscribe")
    Call<Void> unsubscribeUser(@Body User subscriber, @Body User subscribed);

    /**
     * service to indicate to the server that a user joint a group
     * @param user who joined a group
     * @param group which was joined by the user
     * @return void, no response needed
     */
    @POST("/joinGroup")
    Call<Void> joinGroup(@Body User user, @Body Group group);

    /**
     * service to indicate to the server that a user left a group
     * @param user who left a group
     * @param group which was left by the user
     * @return void, no response needed
     */
    @POST("/leaveGroup")
    Call<Void> leaveGroup(@Body User user, @Body Group group);

    /**
     * service to indicate to the server that a user wants to participate in an Event
     * @param user wants to participate in the event
     * @param event which the user wants to participate in
     * @return void, no response needed
     */
    @POST("/participateInEvent")
    Call<Void> participateInEvent(@Body User user, @Body Event event);

    /**
     * service to indicate to the server that a user wants to leave an Event
     * @param user wants to leave in the event
     * @param event which the user wants to leave
     * @return void, no response needed
     */
    @POST("/leaveEvent")
    Call<Void> leaveEvent(@Body User user, @Body Event event);

}
