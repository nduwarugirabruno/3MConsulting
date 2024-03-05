package com.MConsulting.offer.entity.jpa;

import java.util.UUID;

import com.MConsulting.offer.model.like.Like;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class LikeEntity extends Like {
    
    private ProjectOfferEntity projectOfferEntity;

    public LikeEntity() {}

    public LikeEntity(UUID id,UUID userId, String extent, String date) {
        super(id,userId,extent,date);
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public ProjectOfferEntity getProjectOfferEntity() {
        return projectOfferEntity;
    }

    public void setProjectOfferEntity(ProjectOfferEntity projectOfferEntity) {
        this.projectOfferEntity = projectOfferEntity;
    }

    @Override
    @Column(nullable = false)
    public String getDate() {
        return super.getDate();
    }

    @Override
    @Column(nullable = false)
    public String getExtent() {
        return super.getExtent();
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
    public void setDate(String date) {
        super.setDate(date);
    }

    @Override
    public void setExtent(String extent) {
        super.setExtent(extent);
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
