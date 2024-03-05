package com.MConsulting.offer.service.offer;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.MConsulting.offer.model.post.ProjectOffer;

@Service
public interface ProjectOfferService {


    Page<ProjectOffer> findByJobCategoryEntitiesIn(UUID catetory, Pageable pageable);

    ProjectOffer add (UUID clientId, UUID jobCategoryId, ProjectOffer jobOffer);
}
