package com.example.asus.example.mvvm.Model.Entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a user, providing access to the user's unique id, e-mail information, profile picture,
 * subscriptions, subscribers, joined and created groups, participated and created events, created posts and comments,
 * received and sent messages
 */
public class User implements Serializable {

    private int id;
    private String name;
    private String email;
    private String imageUrl;
    private List<User> subscriptions;
    private List<User> subscribers;
    private List<Group> joinedGroups;
    private List<Event> participatedEvents;
    private List<Post> createdPosts;
    private List<Group> createdGroups;
    private List<Event> createdEvents;
    private List<Comment> createdComments;
    private List<Post> likedPosts;

    /**
     * Overwrites Default Constructor and
     * initializes all lists
     */
    public User() {
        this.subscribers = new LinkedList<>();
        this.subscriptions = new LinkedList<>();
        this.joinedGroups = new LinkedList<>();
        this.participatedEvents = new LinkedList<>();
        this.createdPosts = new LinkedList<>();
        this.createdGroups = new LinkedList<>();
        this.createdEvents = new LinkedList<>();
        this.createdComments = new LinkedList<>();
        this.likedPosts = new LinkedList<>();
    }

    /**
     * Constructor with an id. The id is given by the Server-Site;
     * @param id unique identifier of the Object
     * @param name Name of this user.
     * @param email E-Mail address of the user.
     * @param imageUrl Url of the profile picture.
     * @param subscriptions Users, which this user subscribes.
     * @param subscribers Users, which subscribe this user.
     * @param joinedGroups Groups, which this user has joined.
     * @param participatedEvents Events, in which this user has participated.
     * @param createdPosts all the Posts, the User created.
     * @param createdGroups all the Groups, the User created.
     * @param createdEvents all the Events, the User created.
     * @param createdComments all the Comments, the User created.
     */
    public User(int id, String name, String email, String imageUrl, List<User> subscriptions, List<User> subscribers, List<Group> joinedGroups, List<Event> participatedEvents, List<Post> createdPosts, List<Group> createdGroups, List<Event> createdEvents, List<Comment> createdComments, List<Post> likedPosts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
        this.subscriptions = subscriptions;
        this.subscribers = subscribers;
        this.joinedGroups = joinedGroups;
        this.participatedEvents = participatedEvents;
        this.createdPosts = createdPosts;
        this.createdGroups = createdGroups;
        this.createdEvents = createdEvents;
        this.createdComments = createdComments;
        this.likedPosts = likedPosts;

    }

    /**
     * Constructor without an id. Id is given by the Server-Site
     * @param name Name of this user.
     * @param email E-Mail address of the user.
     * @param imageUrl Url of the profile picture.
     * @param subscriptions Users, which this user subscribes.
     * @param subscribers Users, which subscribe this user.
     * @param joinedGroups Groups, which this user has joined.
     * @param participatedEvents Events, in which this user has participated.
     * @param createdPosts all the Posts, the User created.
     * @param createdGroups all the Groups, the User created.
     * @param createdEvents all the Events, the User created.
     * @param createdComments all the Comments, the User created.

     */
    public User(String name, String email, String imageUrl, List<User> subscriptions, List<User> subscribers, List<Group> joinedGroups, List<Event> participatedEvents, List<Post> createdPosts, List<Group> createdGroups, List<Event> createdEvents, List<Comment> createdComments) {
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
        this.subscriptions = subscriptions;
        this.subscribers = subscribers;
        this.joinedGroups = joinedGroups;
        this.participatedEvents = participatedEvents;
        this.createdPosts = createdPosts;
        this.createdGroups = createdGroups;
        this.createdEvents = createdEvents;
        this.createdComments = createdComments;

    }

    /**
     * method to get the id of the User
     * @return id of the User
     */
    public int getId() {
        return id;
    }

    /**
     * sets the id of the User
     * @param id if of the User
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * method to get the name of the User
     * @return the name of the User
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the User
     * @param name name of the User
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method to get the Email of the User.
     * @return the Email of the User.
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets the Email of the User.
     * @param email Email of the User
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * method to get the imageURl of the Users profile picture
     * @return the imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * sets the imageUrl of the Users pofile picture
     * @param imageUrl imageUrl of the Users profile picture
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * method to get the a List of the Users, this User subscribes to
     * @return List of Subscriptions
     */
    public List<User> getSubscriptions() {
        return subscriptions;
    }

    /**
     * sets the a List of the Users, this User subscribes to
     * @param subscriptions List of Subscriptions
     */
    public void setSubscriptions(List<User> subscriptions) {
        this.subscriptions = subscriptions;
    }

    /**
     * method to get the List of Users, who subscribe to this User
     * @return List of Subscribers
     */
    public List<User> getSubscribers() {
        return subscribers;
    }

    /**
     * sets the List of Users, who subscribe to this User
     * @param subscribers List of Subscribers
     */
    public void setSubscribers(List<User> subscribers) {
        this.subscribers = subscribers;
    }

    /**
     * method to get the List of Groups this User joined
     * @return List of joined Groups
     */
    public List<Group> getJoinedGroups() {
        return joinedGroups;
    }

    /**
     * sets the List of Groups this User joined
     * @param joinedGroups List of joined Groups
     */
    public void setJoinedGroups(List<Group> joinedGroups) {
        this.joinedGroups = joinedGroups;
    }

    /**
     * method to get the List of Events this user wants to participate in
     * @return List of Events the user wants to participate in
     */
    public List<Event> getParticipatedEvents() {
        return participatedEvents;
    }

    /**
     * sets the List of Events this user wants to participate in
     * @param participatedEvents List of Events the user wants to participate in
     */
    public void setParticipatedEvents(List<Event> participatedEvents) {
        this.participatedEvents = participatedEvents;
    }

    public List<Post> getCreatedPosts() {
        return createdPosts;
    }

    public void setCreatedPosts(List<Post> createdPosts) {
        this.createdPosts = createdPosts;
    }

    public List<Group> getCreatedGroups() {
        return createdGroups;
    }

    public void setCreatedGroups(List<Group> createdGroups) {
        this.createdGroups = createdGroups;
    }

    public List<Event> getCreatedEvents() {
        return createdEvents;
    }

    public void setCreatedEvents(List<Event> createdEvents) {
        this.createdEvents = createdEvents;
    }

    public List<Comment> getCreatedComments() {
        return createdComments;
    }

    public void setCreatedComments(List<Comment> createdComments) {
        this.createdComments = createdComments;
    }

    public List<Post> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(List<Post> likedPosts) {
        this.likedPosts = likedPosts;
    }

    /**
     * compares two Users by their ids
     *
     * @param object user to compare with
     * @return true if object and this user have the same id, else false
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!User.class.isAssignableFrom(object.getClass())) {
            return false;
        }
        final User other = (User) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
