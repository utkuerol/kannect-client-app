package com.example.asus.example.mvvm.Model.Entities;


import java.util.Date;
import java.util.List;

/**
 * Represents a post, providing access to the post's unique id, text, creator,
 * number of likes, date of creation, comments and the information on whether
 * it is owned by a user, a group or an event.
 */
public class Post {


    private String text;
    private User creator;
    private List<User> likedUsers;
    private Date date;
    private Event belongsToEvent;
    private Group belongsToGroup;
    private User belongsToUser;
    private List<Comment> comments;
    private long id;

    public Post() {
    }

    /**
     * Constructor with an given ID by the Server-Site.
     * A Post can only belong to either an Event, Group or an User.
     * @param text User-created text to be displayed in the post.
     * @param creator User, which created this post.
     * @param likedUsers List of User who liked the Post.
     * @param date Creation date of this post.
     * @param belongstoGroup Post belongs to this Group.
     * @param belongsToUser Post belongs to this User.
     * @param belongsToEvent Post belongs to this Event.
     * @param comments Comments which belong to the Post.
     * @param id unique identifier of the Object.
     */
    public Post(String text, User creator, List<User> likedUsers, Date date, Event belongsToEvent, Group belongstoGroup, User belongsToUser, List<Comment> comments, long id) {
        this.text = text;
        this.creator = creator;
        this.likedUsers = likedUsers;
        this.date = date;
        this.belongsToEvent = belongsToEvent;
        this.belongsToGroup = belongstoGroup;
        this.belongsToUser = belongsToUser;
        this.comments = comments;
        this.id = id;
    }

    /**
     * Constructor without an ID. ID will be given in the Server-Site
     * A Post can only belong to either an Event, Group or an User.
     * @param text User-created text to be displayed in the post.
     * @param creator User, which created this post.
     * @param likedUsers List of User, who liked the Post
     * @param date Creation date of this post.
     * @param belongsToGroup Post belongs to this Group
     * @param belongsToUser Post belongs to this User
     * @param belongsToEvent Post belongs to this Event
     * @param comments Comments which belong to the Post
     */
    public Post(String text, User creator, List<User> likedUsers, Date date, Event belongsToEvent, Group belongsToGroup, User belongsToUser, List<Comment> comments) {
        this.text = text;
        this.creator = creator;
        this.likedUsers = likedUsers;
        this.date = date;
        this.belongsToEvent = belongsToEvent;
        this.belongsToGroup = belongsToGroup;
        this.belongsToUser = belongsToUser;
        this.comments = comments;
    }

    /**
     * method to get the text of the Post
     * @return text of the Post
     */
    public String getText() {
        return text;
    }

    /**
     * sets the text of the Post
     * @param text new text of the Post
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * method to get the user who created the post
     * @return the creator of the post
     */
    public User getCreator() {
        return creator;
    }

    /**
     * method to set the creater of the Post
     * @param creator creator of the Post
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }

    /**
     * method to get the Date of the Post, on which it was created
     * @return Creation-Date of the Post
     */
    public Date getDate() {
        return date;
    }

    /**
     * sets the Creation-Date of the Post
     * @param date new Creation-Date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *  method returns an Event, to which the Post belongs to.
     *  If the Post doesn´t belong to an Event, it returns null.
     * @return the Event the Post belongs to.
     */
    public Event getBelongsToEvent() {
        return belongsToEvent;
    }


    /**
     * method returns a Group, to which the Post belongs to.
     * If the Post doesn´t belong to a Group, it returns null;
     * @return the Group the Post belongs to.
     */
    public Group getBelongsToGroup() {
        return belongsToGroup;
    }


    /**
     * method returns a User, to which the Post belongs to.
     * If the Post doesn´t belong to a User, it returns null.
     * @return User to which Post belongs to
     */
    public User getBelongsToUser() {
        return belongsToUser;
    }

    /**
     * method to return the List of Comments, which belong to the Post
     * @return the List of Comments of the Post
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * sets the List of Comments, which belong to the Post
     * @param comments List of Comments of the Post
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<User> getLikedUsers() {
        return likedUsers;
    }

    public void setLikedUsers(List<User> likedUsers) {
        this.likedUsers = likedUsers;
    }

    public void setBelongsToEvent(Event belongsToEvent) {
        this.belongsToEvent = belongsToEvent;
    }

    public void setBelongsToGroup(Group belongsToGroup) {
        this.belongsToGroup = belongsToGroup;
    }

    public void setBelongsToUser(User belongsToUser) {
        this.belongsToUser = belongsToUser;
    }


}

