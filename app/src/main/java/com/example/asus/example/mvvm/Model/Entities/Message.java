package com.example.asus.example.mvvm.Model.Entities;

import com.example.asus.example.mvvm.Model.Entities.User;

import java.util.Date;

/**
 * Represents a message, providing access to the message's unique id, text,
 * sender, receiver and date of creation
 */
public class Message {


    private String text;

    private User sender;

    private User receiver;

    private Date date;

    private long id;

    /**
     *
     * @param text User-created text to be displayed in this message
     * @param sender User, which sent this message
     * @param receiver User, which received this message
     * @param date Date of creation of this message
     */
    public Message(String text, User sender, User receiver, Date date) {
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
        this.date = date;

    }

    /**
     * Constructor with an id. The id is given by the Server-Site
     * @param text User-created text to be displayed in this message
     * @param sender User, which sent this message
     * @param receiver User, which received this message
     * @param date Date of creation of this message
     * @param id unique Identifier of the Message
     */
    public Message(String text, User sender, User receiver, Date date, long id) {
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
        this.date = date;
        this.id = id;
    }

    /**
     * method to get the text of the message
     * @return text of the message
     */
    public String getText() {
        return text;
    }

    /**
     * sets the text of the message
     * @param text text of the message
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * method to get the User who send the message
     * @return User who send the message
     */
    public User getSender() {
        return sender;
    }

    /**
     *sets the User who send the message
     * @param sender User who send the message
     */
    public void setSender(User sender) {
        this.sender = sender;
    }

    /**
     * method to get the User who the message was sent to
     * @return User whom the message was sent to
     */
    public User getReceiver() {
        return receiver;
    }

    /**
     * sets the User who the message was sent to
     * @param receiver User whom the message was sent to
     */
    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    /**
     * method to get the Date, when the message was sent
     * @return the Date, when message was sent
     */
    public Date getDate() {
        return date;
    }

    /**
     * sets the Date, when the message was sent
     * @param date Date, when message was sent
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * method to get the id of the Message
     * @return id of the Message
     */
    public long getId() {
        return id;
    }

    /**
     * sets the id of the Message
     * @param id of the Message
     */
    public void setId(long id) {
        this.id = id;
    }
}

