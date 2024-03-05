package com.MConsulting.offer.service.category;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.MConsulting.offer.model.category.JobCategory;

@Service
public interface JobCategoryService {

    public JobCategory findById(UUID id);

    public JobCategory add (JobCategory jobCategory);
}
