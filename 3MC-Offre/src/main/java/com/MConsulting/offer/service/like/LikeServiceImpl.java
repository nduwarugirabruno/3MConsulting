package com.MConsulting.offer.service.like;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.MConsulting.offer.model.like.Like;
import com.MConsulting.offer.repository.like.LikeRepository;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;

    public LikeServiceImpl (LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }


    @Override
    public Like add(UUID posId, Like like) {
        return this.likeRepository.add(posId, like);
    }
    
}
