package com.example.asus.example.mvvm.Model.Entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a category, providing access to the category's unique id, name, subcategories,
 * groups and events.
 */
public class Category implements Serializable{

    private String name;
    private List<Subcategory> subcategories;
    private List<Event> events;
    private List<Group> groups;
    private int id;

    /**
     * Overwrites Default Constructor and
     * initializes all lists
     */
    public Category() {
        this.subcategories = new LinkedList<>();
        this.events = new LinkedList<>();
        this.groups = new LinkedList<>();
    }
    /**
     * Constructor without an id. Id´s will be given in Server-Site
     * @param name Name of the category.
     * @param subcategories Subcategories, which fall into this category.
     * @param events Events, which fall into this category.
     * @param groups Groups, which fall into this category.
     */
    public Category(String name, List<Subcategory> subcategories, List<Event> events, List<Group> groups) {
        this.name = name;
        this.subcategories = subcategories;
        this.events = events;
        this.groups = groups;
    }


    /**
     * Constructor with id, which was given by the Server-Site.
     * @param name Name of the category.
     * @param subcategories Subcategories, which fall into this category.
     * @param events Events, which fall into this category.
     * @param groups Groups, which fall into this category.
     * @param id unique Identifier of the Category
     */
    public Category(String name, List<Subcategory> subcategories, List<Event> events, List<Group> groups, int id) {
        this.name = name;
        this.subcategories = subcategories;
        this.events = events;
        this.groups = groups;
        this.id = id;
    }

    /**
     * method to get the name of the Category
     * @return name of the Category
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the Category
     * @param name name of the Category
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method to get the List of Subcategories of the Category
     * @return List of Subcategories of the Category
     */
    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    /**
     * sets the List of Subcategories of the Category
     * @param subcategories List of Subcategories of the Category
     */
    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    /**
     * method to get the List of Events of the Category
     * @return the List of Events of the Category
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * set the List of Events of the Category
     * @param events List of Events of the Category
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    /**
     * method to get the List of Groups of the Category
     * @return List of Groups of the Category
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * sets the List of Groups of the Category
     * @param groups List of Groups of the Category
     */
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    /**
     * method to get the id of the Category
     * @return id of the Category
     */
    public int getId() {
        return id;
    }

    /**
     * sets the id of the Category
     * @param id of the Category
     */
    public void setId(int id) {
        this.id = id;
    }
}
