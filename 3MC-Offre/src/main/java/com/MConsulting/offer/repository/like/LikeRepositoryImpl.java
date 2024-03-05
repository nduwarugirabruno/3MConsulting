package com.MConsulting.offer.repository.like;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.MConsulting.offer.entity.jpa.LikeEntity;
import com.MConsulting.offer.entity.jpa.ProjectOfferEntity;
import com.MConsulting.offer.model.like.Like;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class LikeRepositoryImpl implements LikeRepository {

    private final JpaLikeRepository jpaLikeRepository;
    private final EntityManager entityManager;

    public LikeRepositoryImpl(JpaLikeRepository jpaLikeRepository, EntityManager entityManager) {
        this.jpaLikeRepository = jpaLikeRepository;
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public Like add(UUID postID, Like like) {
        ProjectOfferEntity projectOfferEntity = entityManager.find(ProjectOfferEntity.class, postID);
        LikeEntity likeEntity = new LikeEntity();
        likeEntity.setDate(LocalDate.now().toString());
        likeEntity.setExtent(like.getExtent());
        likeEntity.setUserId(like.getUserId());
        likeEntity.setProjectOfferEntity(projectOfferEntity);
        
        return entityManager.merge(likeEntity);

    }
   
} 