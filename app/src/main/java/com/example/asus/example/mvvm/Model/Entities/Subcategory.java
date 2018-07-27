package com.example.asus.example.mvvm.Model.Entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a subcategory, providing access to the subcategory's unique id, name, parent category,
 * groups and events.
 */
public class Subcategory implements Serializable {


    private String name;
    private Category category;
    private List<Event> events;
    private List<Group> groups;
    private int id;

    /**
     * Overwrites Default Constructor and
     * initializes all lists
     */
    public Subcategory() {
        this.events = new LinkedList<>();
        this.groups = new LinkedList<>();
    }
    /**
     * Constructor without an ID. ID will be given by Server-Site
     * @param name Name of the subcategory
     * @param category Parent category of this subcategory
     * @param events Events, which fall into this subcategory
     * @param groups Groups, which fall into this subcategory
     */
    public Subcategory(String name, Category category, List<Event> events, List<Group> groups) {
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
    public Subcategory(String name, Category category, List<Event> events, List<Group> groups, int id) {
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
    public List<Event> getEvents() {
        return events;
    }

    /**
     * sets the Set Events which belong to this Subcategory
     * @param events Events which belong to this Subcategory
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    /**
     * method to get the Set of Groups which belong to this Subcategory
     * @return Set of groups which belong to this Subcategory
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * sets the Set of Groups which belong to this Subcategory
     * @param groups which belong to this Subcategory
     */
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    /**
     * method returns the id of the Subcategory
     * @return the id of Subcategory
     */
    public int getId() {
        return id;
    }

    /**
     * sets the id of the Subcategory
     * @param id of the Subcategory
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * compares two Subcategories by their ids
     *
     * @param object subcategory to compare with
     * @return true if object and this subcategory have the same id, else false
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!Subcategory.class.isAssignableFrom(object.getClass())) {
            return false;
        }
        final Subcategory other = (Subcategory) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
