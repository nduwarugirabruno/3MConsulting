package com.MConsulting.offer.service.like;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.MConsulting.offer.model.like.Like;

@Service
public interface LikeService {
    
    public Like add (UUID posId, Like like);
}
