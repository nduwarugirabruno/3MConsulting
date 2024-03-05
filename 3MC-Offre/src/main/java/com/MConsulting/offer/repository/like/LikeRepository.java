package com.MConsulting.offer.repository.like;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.MConsulting.offer.model.like.Like;

@Repository
public interface LikeRepository {
    
    public Like add(UUID postId, Like like);
}
