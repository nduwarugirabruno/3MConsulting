package com.MConsulting.offer.repository.category;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.MConsulting.offer.entity.jpa.JobCategoryEntity;
import com.MConsulting.offer.model.category.JobCategory;

@Repository
public class JobCategoryRepositoryImpl implements JobCategoryRepository {

    private final JpaJobCategoryRepository JpaJobCategoryRepository;
    
    public JobCategoryRepositoryImpl(JpaJobCategoryRepository jpaJobCategoryRepository) {
        this.JpaJobCategoryRepository = jpaJobCategoryRepository;
    }


    @Override
    public JobCategory findById(UUID id) {
        return this.JpaJobCategoryRepository.findById(id).orElse(null);
    }


    @Override
    public JobCategory add(JobCategory jobCategory) {
       
        JobCategoryEntity jobCategoryEntity = JobCategoryEntity.from(jobCategory);    
        return this.JpaJobCategoryRepository.save(jobCategoryEntity);

    }    


}
