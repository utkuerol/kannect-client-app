package com.example.asus.example.mvvm.Model.Entities;

import java.util.Set;

/**
 * Represents a subcategory, providing access to the subcategory's unique id, name, parent category,
 * groups and events.
 */
public class Subcategory {


    private String name;
    private Category category;
    private Set<Event> events;
    private Set<Group> groups;
    private long id;

    /**
     * Constructor without an ID. ID will be given by Server-Site
     * @param name Name of the subcategory
     * @param category Parent category of this subcategory
     * @param events Events, which fall into this subcategory
     * @param groups Groups, which fall into this subcategory
     */
    public Subcategory(String name, Category category, Set<Event> events, Set<Group> groups) {
        this.name = name;
        this.category = category;
        this.events = events;
        this.groups = groups;
    }


    /**
     * Constructor with an ID. Id will be given by the Server-Site
     * @param name Name of the subcategory
     * @param category Parent category of this subcategory
     * @param events Events, which fall into this subcategory
     * @param groups Groups, which fall into this subcategory
     * @param id unique identifier of the Subcategory
     */
    public Subcategory(String name, Category category, Set<Event> events, Set<Group> groups, long id) {
        this.name = name;
        this.category = category;
        this.events = events;
        this.groups = groups;
        this.id = id;
    }

    /**
     * method to get the name of the Subcategory
     * @return name of the Subcategory
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the Subcategory
     * @param name new name of the Subcategory
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method to get the Parent Category of this Subcategory
     * @return parent Category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * sets a Parent Category for this Subcategory
     * @param category Parent Category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * method to get the Set of Events which belong to the Subcategory
     * @return the Events of this Subcategory
     */
    public Set<Event> getEvents() {
        return events;
    }

    /**
     * sets the Set Events which belong to this Subcategory
     * @param events Events which belong to this Subcategory
     */
    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    /**
     * method to get the Set of Groups which belong to this Subcategory
     * @return Set of groups which belong to this Subcategory
     */
    public Set<Group> getGroups() {
        return groups;
    }

    /**
     * sets the Set of Groups which belong to this Subcategory
     * @param groups which belong to this Subcategory
     */
    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    /**
     * method returns the id of the Subcategory
     * @return the id of Subcategory
     */
    public long getId() {
        return id;
    }

    /**
     * sets the id of the Subcategory
     * @param id of the Subcategory
     */
    public void setId(long id) {
        this.id = id;
    }
}
