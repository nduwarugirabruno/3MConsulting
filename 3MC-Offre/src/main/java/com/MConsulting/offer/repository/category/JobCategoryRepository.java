package com.MConsulting.offer.repository.category;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.MConsulting.offer.model.category.JobCategory;

@Repository
public interface JobCategoryRepository {

    public JobCategory findById(UUID id);

    public JobCategory add (JobCategory jobCategory);

}
