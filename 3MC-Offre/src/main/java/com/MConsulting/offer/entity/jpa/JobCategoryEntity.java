package com.MConsulting.offer.entity.jpa;

import java.util.List;
import java.util.UUID;

import com.MConsulting.offer.model.category.JobCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class JobCategoryEntity extends JobCategory{
   
    private List<ProjectOfferEntity> projectOfferEntities;

    public JobCategoryEntity() {}

    @Override
    @Column(nullable = false)
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    @Column(nullable = false)
    public String getImage() {
        return super.getImage();
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public void setImage(String image) {
        super.setImage(image);
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID getId() {
        return super.getId();
    }

    @Override
    @Column(nullable = false)
    public String getName() {
        return super.getName();
    }


    @Override
    public void setId(UUID id) {
        super.setId(id);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "jobCategoryEntities")
    public List<ProjectOfferEntity> getProjectOfferEntities() {
        return this.projectOfferEntities;
    }

    public void setProjectOfferEntities(List<ProjectOfferEntity> projectOfferEntities) {
        this.projectOfferEntities = projectOfferEntities;
    }

    public static JobCategoryEntity from (JobCategory jobCategory) {

        JobCategoryEntity jobCategoryEntity = new JobCategoryEntity();

        jobCategoryEntity.setName(jobCategory.getName());
        jobCategoryEntity.setDescription(jobCategory.getDescription());
        jobCategoryEntity.setImage(jobCategory.getImage());

        return jobCategoryEntity;
}


}
