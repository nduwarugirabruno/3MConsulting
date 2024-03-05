package com.MConsulting.offer.model.comment;

import java.util.UUID;

import com.MConsulting.offer.model.post.ProjectOffer;

public class ProjectOfferComment extends AbstractComment{

    private String content;

    private ProjectOffer projectOffer;
    
    public ProjectOfferComment() {
    }
    
    public ProjectOfferComment(UUID id, String datePosted, UUID userId, String content, ProjectOffer projectOffer) {
        super(id, datePosted, userId);
        this.content = content;
        this.projectOffer = projectOffer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ProjectOffer getProjectOffer() {
        return projectOffer;
    }

    public void setProjectOffer(ProjectOffer projectOffer) {
        this.projectOffer = projectOffer;
    }
    
    



}
