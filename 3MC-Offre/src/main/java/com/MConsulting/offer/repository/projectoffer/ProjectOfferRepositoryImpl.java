package com.MConsulting.offer.repository.projectoffer;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.MConsulting.offer.entity.jpa.JobCategoryEntity;
import com.MConsulting.offer.entity.jpa.ProjectOfferEntity;
import com.MConsulting.offer.model.category.JobCategory;
import com.MConsulting.offer.model.post.ProjectOffer;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class ProjectOfferRepositoryImpl implements ProjectOfferRepository{

    private final JpaProjectOfferRepository jpaProjectOfferRepository;

    private final EntityManager entityManager;

    public ProjectOfferRepositoryImpl(JpaProjectOfferRepository jpaProjectOfferRepository, EntityManager entityManager) {
        this.entityManager = entityManager; 
        this.jpaProjectOfferRepository = jpaProjectOfferRepository;
    }

    @Override
    public Page<ProjectOffer> findByJobCategoryEntitiesIn(List<JobCategory> jobCategory,
            Pageable pageable) {
                List<JobCategoryEntity> jobCategoryEntities = jobCategory.stream().map(JobCategoryEntity::from).collect(Collectors.toList());
                
                return jpaProjectOfferRepository.findByJobCategoryEntitiesIn(jobCategoryEntities, pageable).map(ProjectOfferEntity::toModel);

    }

    @Override
    @Transactional
    public ProjectOffer add(UUID clientId, UUID jobCategoryId, ProjectOffer jobOffer) {
        
        JobCategoryEntity jobCategoryEntity = entityManager.find(JobCategoryEntity.class, jobCategoryId);

        
        ProjectOfferEntity projectOfferEntity = ProjectOfferEntity.from(jobOffer);
        projectOfferEntity.setUserId(clientId);
        projectOfferEntity.setJobCategoryEntities(List.of(jobCategoryEntity));
        entityManager.merge(projectOfferEntity);
        entityManager.close();

        return projectOfferEntity;
    }
}
