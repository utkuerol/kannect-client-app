package com.example.asus.example.mvvm.Model.Entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents an group, providing access to the group's unique id, name, description, category, subcategory,
 * creator, profile picture url and members.
 */
public class Group implements Serializable {

    private int id;
    private String name;
    private String description;
    private User creator;
    private Category category;
    private Subcategory subcategory;
    private String imageURl;
    private List<User> members;

    /**
     *
     */
    public Group() {
        this.members = new LinkedList<>();
    }

    /**
     * Constructor with the id. Id is given by the Server-Site.
     * @param id unique identifier of the Group object
     * @param name Name of the group.
     * @param description Description of the group, containing extra information intended to be given from the user.
     * @param creator User, which created this group.
     * @param category Category, into which this group falls.
     * @param subcategory Subcategory, into which this group falls.
     * @param imageURl Url of the profile picture.
     * @param members Users, which have joined this group.
     */
    public Group(int id, String name, String description, User creator, Category category, Subcategory subcategory, String imageURl, List<User> members) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creator = creator;
        this.category = category;
        this.subcategory = subcategory;
        this.imageURl = imageURl;
        this.members = members;
    }


    /**
     * Constructor without an id. Id is given by the Server-Site.
     * @param name Name of the group.
     * @param description Description of the group, containing extra information intended to be given from the user.
     * @param creator User, which created this group.
     * @param category Category, into which this group falls.
     * @param subcategory Subcategory, into which this group falls.
     * @param imageURl Url of the profile picture.
     * @param members Users, which have joined this group.
     */
    public Group(String name, String description, User creator, Category category, Subcategory subcategory, String imageURl, List<User> members) {
        this.name = name;
        this.description = description;
        this.creator = creator;
        this.category = category;
        this.subcategory = subcategory;
        this.imageURl = imageURl;
        this.members = members;
    }

    /**
     * method to get the id of the Group.
     * @return id of the Group.
     */
    public int getId() {
        return id;
    }

    /**
     * sets the id of the Group.
     * @param id ID of the Group.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * method to get the name of the Group.
     * @return name of the Group.
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the Group.
     * @param name name of the Group.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method to get the description of the Group.
     * @return the description of the Group.
     */
    public String getDescription() {
        return description;
    }

    /**
     * sets the discription of the Group.
     * @param description Description of the Group.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * method to get the User, who created the Group.
     * @return Creator of the Group.
     */
    public User getCreator() {
        return creator;
    }

    /**
     * sets the User who created the Group.
     * @param creator Creator of the Group.
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }

    /**
     * method to get The Category this Group belongs to.
     * @return Category this Group belongs to.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * sets the Category this Group belongs to.
     * @param category Category this Group belongs to
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * method to get the Subcategory this Group belongs to.
     * @return Subcategory this Group belongs to.
     */
    public Subcategory getSubcategory() {
        return subcategory;
    }

    /**
     * sets the Subcategory this Group belongs to.
     * @param subcategory Subcategory this Group belongs to.
     */
    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    /**
     * method to get the imageUrl of the profile picture of this Group
     * @return the imageUrl of this Group
     */
    public String getImageURl() {
        return imageURl;
    }

    /**
     * sets the imageUrl for the Profil picture of this Group
     * @param imageURl imageurl of the Profile Picture
     */
    public void setImageURl(String imageURl) {
        this.imageURl = imageURl;
    }

    /**
     * method to get the List of Users who joined the Group
     * @return List of Members
     */
    public List<User> getMembers() {
        return members;
    }

    /**
     * sets the List of Users who joined the Group
     * @param members List of Members
     */
    public void setMembers(List<User> members) {
        this.members = members;
    }
}

