package com.MConsulting.offer.repository.like;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MConsulting.offer.entity.jpa.LikeEntity;

public interface JpaLikeRepository extends JpaRepository<LikeEntity, UUID>{

    
} 