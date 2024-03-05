package com.MConsulting.offer.model.post;

import java.util.UUID;

public abstract class Post {
   
    private UUID id;

    private String title;

    private String datePosted;

    private String image;
    
    private UUID userId;


    public Post() {
    }


    public Post(UUID id, String title, String datePosted, String image, UUID userId) {
        this.id = id;
        this.title = title;
        this.datePosted = datePosted;
        this.image = image;
        this.userId = userId;   
    }

    public UUID getId() {
        return this.id;
    }   

    public void setId(UUID id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getDatePosted() {
        return datePosted;
    }


    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }


    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    
}
