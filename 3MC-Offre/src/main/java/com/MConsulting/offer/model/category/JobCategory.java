package com.MConsulting.offer.model.category;

import java.util.UUID;

public class JobCategory extends AbstractCategory {

    private String description;

    private String image;

    public JobCategory() {
    }

    public JobCategory( UUID id, String name, String description, String image) {
        super(id, name);
        this.description = description;
        this.image = image;
    }   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
