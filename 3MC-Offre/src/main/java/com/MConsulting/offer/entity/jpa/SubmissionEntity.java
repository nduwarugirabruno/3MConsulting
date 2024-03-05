package com.MConsulting.offer.entity.jpa;

import java.util.UUID;

import com.MConsulting.offer.model.submission.JobSubmission;
import com.MConsulting.offer.model.submission.JobSubmissionStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SubmissionEntity extends JobSubmission {

    private ProjectOfferEntity projectOfferEntity;

    @Override
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public JobSubmissionStatus getJobSubmissionStatus() {
        return super.getJobSubmissionStatus();
    }

    @Override
    @Column(nullable = false)
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public void setJobSubmissionStatus(JobSubmissionStatus jobSubmissionStatus) {
        super.setJobSubmissionStatus(jobSubmissionStatus);
    }

    @Override
    public void setMessage(String message) {
        super.setMessage(message);
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID getId() {
        return super.getId();
    }

    @Override
    public void setId(UUID id) {
        super.setId(id);
    }

    @ManyToOne
    public ProjectOfferEntity getProjectOfferEntity() {
        return projectOfferEntity;
    }

    public void setProjectOfferEntity(ProjectOfferEntity projectOfferEntity) {
        this.projectOfferEntity = projectOfferEntity;
    }
    

    
}
