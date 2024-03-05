package com.MConsulting.offer.entity.jpa;

import java.util.UUID;

import com.MConsulting.offer.model.comment.ProjectOfferComment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CommentEntity extends ProjectOfferComment{

    private ProjectOfferEntity projectOfferEntity;

    @Override
    @Column(nullable = false)
    public String getContent() {
        return super.getContent();
    }

    @Override
    public void setContent(String content) {
        super.setContent(content);
    }

    @Override
    @Column(nullable = false)
    public String getDatePosted() {
        return super.getDatePosted();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public ProjectOfferEntity getProjectOfferEntity() {
        return projectOfferEntity;
    }

    public void setProjectOfferEntity(ProjectOfferEntity projectOfferEntity) {
        this.projectOfferEntity = projectOfferEntity;
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID getId() {
        return super.getId();
    }

    @Override
    @Column(nullable = false)
    public UUID getUserId() {
        return super.getUserId();
    }

    @Override
    public void setDatePosted(String datePosted) {
        super.setDatePosted(datePosted);
    }

    @Override
    public void setId(UUID id) {
        super.setId(id);
    }

    @Override
    public void setUserId(UUID userId) {
        super.setUserId(userId);
    }

    
}