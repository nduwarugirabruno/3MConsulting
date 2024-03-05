package com.MConsulting.offer.service.category;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.MConsulting.offer.model.category.JobCategory;
import com.MConsulting.offer.repository.category.JobCategoryRepository;


@Service
public class JobCategoryServiceImpl implements JobCategoryService{

    private final JobCategoryRepository jobCategoryRepository;

    public JobCategoryServiceImpl(JobCategoryRepository jobCategoryRepository) {
        this.jobCategoryRepository = jobCategoryRepository;
    }

    @Override
    public JobCategory findById(UUID id) {
        return this.jobCategoryRepository.findById(id);
    }
    
    @Override
    public JobCategory add(JobCategory jobCategory) {
        return this.jobCategoryRepository.add(jobCategory);
    }
}
