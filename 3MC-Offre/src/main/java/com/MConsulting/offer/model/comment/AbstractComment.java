package com.MConsulting.offer.model.comment;

import java.util.UUID;

public abstract class AbstractComment {
    
    private UUID id;

    private String datePosted;

    private UUID userId;

    public AbstractComment() {
    }

    public AbstractComment(UUID id, String datePosted, UUID userId) {
        this.id = id;
        this.datePosted = datePosted;
        this.userId = userId;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

}
