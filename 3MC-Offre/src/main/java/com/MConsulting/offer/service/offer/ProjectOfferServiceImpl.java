package com.MConsulting.offer.service.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.MConsulting.offer.model.category.JobCategory;
import com.MConsulting.offer.model.post.ProjectOffer;
import com.MConsulting.offer.repository.category.JobCategoryRepository;
import com.MConsulting.offer.repository.projectoffer.ProjectOfferRepository;

@Service
public class ProjectOfferServiceImpl implements ProjectOfferService {
    
    private final ProjectOfferRepository projectOfferRepository;
    private final JobCategoryRepository jobCategoryRepository;

    public ProjectOfferServiceImpl(ProjectOfferRepository projectOfferRepository, JobCategoryRepository jobCategoryRepository) {
        this.projectOfferRepository = projectOfferRepository;
        this.jobCategoryRepository = jobCategoryRepository;
    }

    @Override
    public Page<ProjectOffer> findByJobCategoryEntitiesIn(UUID category,
            Pageable pageable) {
                JobCategory jobCategory  = jobCategoryRepository.findById(category);

                List<JobCategory> jobCategories = new ArrayList<>();

                jobCategories.add(jobCategory);
                return projectOfferRepository.findByJobCategoryEntitiesIn(jobCategories, pageable);

    }

    @Override
    public ProjectOffer add(UUID clientId, UUID jobCategoryId, ProjectOffer jobOffer) {
        return projectOfferRepository.add(clientId, jobCategoryId, jobOffer);
    }
    
}
