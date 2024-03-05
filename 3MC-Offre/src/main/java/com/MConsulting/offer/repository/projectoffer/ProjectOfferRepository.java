package com.MConsulting.offer.repository.projectoffer;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.MConsulting.offer.model.category.JobCategory;
import com.MConsulting.offer.model.post.ProjectOffer;

@Repository
public interface ProjectOfferRepository {
    
    Page<ProjectOffer> findByJobCategoryEntitiesIn(List<JobCategory> jobCategoryEntities, Pageable pageable); 

    ProjectOffer add(UUID clientId, UUID jobCategoryId, ProjectOffer jobOffer);
}
