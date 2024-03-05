package com.MConsulting.offer.model.category;

import java.util.UUID;

public abstract class AbstractCategory {
    
    private UUID id;

    private String name;

    public AbstractCategory() {
    }

    public AbstractCategory (UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
