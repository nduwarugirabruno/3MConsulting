package com.MConsulting.offer.repository.comment;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MConsulting.offer.entity.jpa.CommentEntity;

public interface JpaCommentRepository extends JpaRepository<CommentEntity, UUID> {
    
}
