package com.example.asus.example.mvvm.Model.Entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents a comment, providing access to the comment's unique id, text, creator, belonging post and
 * date of creation
 */
public class Comment implements Serializable {


    private String text;

    private Post post;

    private Date date;

    private User creator;

    private long id;


    /**
     *
     * @param text User-created text to be displayed in the comment
     * @param post Post, to which this comment belongs
     * @param date Creation date of this comment
     * @param creator User, which created this comment
     */
    public Comment(String text, Post post, Date date, User creator) {
        this.text = text;
        this.post = post;
        this.date = date;
        this.creator = creator;
    }

    /**
     *
     * @param text User-created text to be displayed in the comment
     * @param post Post, to which this comment belongs
     * @param date Creation date of this comment
     * @param creator User, which created this comment
     * @param id unique Identifier of the Object
     */
    public Comment(String text, Post post, Date date, User creator, long id) {
        this.text = text;
        this.post = post;
        this.date = date;
        this.creator = creator;
        this.id = id;
    }

    /**
     * method to get the text of the comment
     * @return text of the comment
     */
    public String getText() {
        return text;
    }

    /**
     * method to get the Post, to which the comment belongs
     * @return post, to which comment belongs
     */
    public Post getPost() {
        return post;
    }

    /**
     * method to get the Creation-Date
     * @return creation-date of the comment
     */
    public Date getDate() {
        return date;
    }

    /**
     * method to get the Creator of the comment
     * @return creator of the comment
     */
    public User getCreator() {
        return creator;
    }

    /**
     * sets the text of the comment
     * @param text text of the comment
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * sets the post to which the comment belongs
     * @param post post to which the comment belongs
     */
    public void setPost(Post post) {
        this.post = post;
    }

    /**
     * sets the creation-date of the comment
     * @param date creation-date of the comment
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * sets the creator of the comment
     * @param creator creator of the comment
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }

    /**
     * method to get the id of the Comment
     * @return id of the Comment
     */
    public long getId() {
        return id;
    }

    /**
     * sets the id of the Comment
     * @param id of the Comment
     */
    public void setId(long id) {
        this.id = id;
    }
}

