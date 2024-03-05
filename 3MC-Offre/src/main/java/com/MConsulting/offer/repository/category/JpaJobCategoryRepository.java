package com.MConsulting.offer.repository.category;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MConsulting.offer.entity.jpa.JobCategoryEntity;

public interface JpaJobCategoryRepository extends JpaRepository<JobCategoryEntity, UUID>{
    
}
