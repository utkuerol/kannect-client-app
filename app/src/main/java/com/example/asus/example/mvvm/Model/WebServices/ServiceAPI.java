package com.example.asus.example.mvvm.Model.WebServices;



import com.example.asus.example.mvvm.Model.Entities.Category;
import com.example.asus.example.mvvm.Model.Entities.Comment;
import com.example.asus.example.mvvm.Model.Entities.Event;
import com.example.asus.example.mvvm.Model.Entities.Group;
import com.example.asus.example.mvvm.Model.Entities.Message;
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
     * service to edit an existing event
     * @param editedEvent  edited Event
     * @return void, no response needed
     */
    @POST("/edit")
    Call<Event> editEvent(@Body Event editedEvent);

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
     * service to edit a Group
     * @param editedGroup the edited Group
     * @return void, no response needed
     */
    @POST("/editGroup")
    Call<Group> editGroup(@Body Group editedGroup);

    /**
     * service to get all received messages
     * @param userID user of which all received message are asked for
     * @return List of all received Messages as a Response Object
     */
    @GET("/receivedMessages")
    Call<List<Message>> getReceivedMessages(long userID);

    /**
     * service to to get all sent Messages by a user
     * @param userID user of which all sent Messages are asked for
     * @return List of all sent Messages as a Repsonse Object
     */
    @GET("/sentMessages")
    Call<List<Message>> getSentMessages(long userID);

    /**
     * service to send  a message
     * @param message Message which will be send
     * @return void, no response needed
     */
    @POST("/sendMessage")
    Call<Message> sendMessage(@Body Message message);

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
     * service to edit an existing Post
     * @param editedPost Post with wanted changes
     * @return void, no response needed
     */
    @POST("/editPost")
    Call<Post>  editPost(@Body Post editedPost);

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
     * @param post which was commented by user
     * @param user user which commented a post
     * @param comment by the user
     * @return void, no response needed
     */
    @Multipart
    @POST("/commentPost")
    Call<ResponseBody> commentPost(@Part Post post, @Part User user, @Part Comment comment);

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



}
