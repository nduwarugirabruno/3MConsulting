package com.MConsulting.offer.model.like;

import java.util.UUID;

public class Like {

    private UUID id;

    private UUID userId;

    private String extent;

    private String date;

    public Like() {
    }

    public Like(UUID id, UUID userId, String extent, String date) { 
        this.id = id;
        this.userId = userId;
        this.extent = extent;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getExtent() {
        return extent;
    }

    public void setExtent(String extent) {
        this.extent = extent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    

}
