package com.example.asus.example.mvvm.Model.Entities;


import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a post, providing access to the post's unique id, text, creator,
 * number of likes, date of creation, comments and the information on whether
 * it is owned by a user, a group or an event.
 */
public class Post implements Serializable {


    private String text;
    private User creator;
    private List<User> likedUsers;
    private Date date;
    private long ownedBy;
    private User ownerUser;
    private Group ownerGroup;
    private Event ownerEvent;
    private List<Comment> comments;
    private int id;

    /*

     */
    public Post() {
        this.likedUsers = new LinkedList<>();
        this.comments = new LinkedList<>();
    }

    /**
     * Constructor with an given ID by the Server-Site.
     * A Post can only belong to either an Event, Group or an User.
     * @param text User-created text to be displayed in the post.
     * @param creator User, which created this post.
     * @param likedUsers List of User who liked the Post.
     * @param date Creation date of this post.
     * @param comments Comments which belong to the Post.
     * @param id unique identifier of the Object.
     * @param ownedBy id of the entity, which this posts belongs to
     */
    public Post(String text, User creator, List<User> likedUsers, Date date, List<Comment> comments, int id, long ownedBy) {
        this.text = text;
        this.creator = creator;
        this.likedUsers = likedUsers;
        this.date = date;
        this.comments = comments;
        this.id = id;
        this.ownedBy = ownedBy;
    }

    /**
     * Constructor without an ID. ID will be given in the Server-Site
     * A Post can only belong to either an Event, Group or an User.
     * @param text User-created text to be displayed in the post.
     * @param creator User, which created this post.
     * @param likedUsers List of User, who liked the Post
     * @param date Creation date of this post.
     * @param comments Comments which belong to the Post
     * @param ownedBy id of the entity, which this posts belongs to
     */
    public Post(String text, User creator, List<User> likedUsers, Date date, List<Comment> comments, long ownedBy) {
        this.text = text;
        this.creator = creator;
        this.likedUsers = likedUsers;
        this.date = date;
        this.comments = comments;
        this.ownedBy = ownedBy;
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
     * method to get the List of Comments, which belong to the Post
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

    /**
     * method to get the list of users who liked the post
     *
     * @return list of user who like the post
     */
    public List<User> getLikedUsers() {
        return likedUsers;
    }

    /**
     * sets the list of users who liked the post
     * @param likedUsers new list of users who liked the post
     */
    public void setLikedUsers(List<User> likedUsers) {
        this.likedUsers = likedUsers;
    }

    /**
     * method to get the id of the post
     * @return id of the post
     */
    public int getId() {
        return id;
    }

    /**
     * method to get the id of the entity which this posts belongs to
     *
     * @return id of the entity
     */
    public long getOwnedBy() {
        return ownedBy;
    }

    /**
     * sets the id of the entity this post belongs to
     *
     * @param ownedBy id of the entity
     */
    public void setOwnedBy(long ownedBy) {
        this.ownedBy = ownedBy;
    }

    public User getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(User ownerUser) {
        this.ownerUser = ownerUser;
    }

    public Group getOwnerGroup() {
        return ownerGroup;
    }

    public void setOwnerGroup(Group ownerGroup) {
        this.ownerGroup = ownerGroup;
    }

    public Event getOwnerEvent() {
        return ownerEvent;
    }

    public void setOwnerEvent(Event ownerEvent) {
        this.ownerEvent = ownerEvent;
    }

    /**
     * compares two posts by their ids
     *
     * @param object post to compare with
     * @return true if object and this post have the same id, else false
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!Post.class.isAssignableFrom(object.getClass())) {
            return false;
        }
        final Post other = (Post) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}

