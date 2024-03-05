package com.MConsulting.offer.repository.projectoffer;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.MConsulting.offer.entity.jpa.JobCategoryEntity;
import com.MConsulting.offer.entity.jpa.ProjectOfferEntity;

public interface JpaProjectOfferRepository extends JpaRepository<ProjectOfferEntity, UUID>{

    
    @EntityGraph(value = "projectoffer-with-related-fields")
    Page<ProjectOfferEntity> findByJobCategoryEntitiesIn(List<JobCategoryEntity> jobCategoryEntities, Pageable pageable); 
} 