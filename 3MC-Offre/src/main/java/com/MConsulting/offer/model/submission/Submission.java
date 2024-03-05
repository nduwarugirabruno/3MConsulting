package com.MConsulting.offer.model.submission;

import java.util.UUID;

public abstract class Submission {
    
    private UUID id;

    public Submission() {}

    public Submission(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


}

