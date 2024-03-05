package com.MConsulting.offer.entity.jpa;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.MConsulting.offer.model.post.ProjectOffer;
import com.MConsulting.offer.model.post.ProjectOfferStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedEntityGraphs;
import jakarta.persistence.OneToMany;

@Entity
@NamedEntityGraphs(
    value = {
        @NamedEntityGraph(
            name = "projectoffer-with-related-fields",
            attributeNodes = {
                @NamedAttributeNode("jobCategoryEntities"),
                @NamedAttributeNode("commentEntities"),
                @NamedAttributeNode("likeEntities"),
                @NamedAttributeNode("submissionEntities"),
            }
        )
    }

)
public class ProjectOfferEntity extends ProjectOffer {
   
    private List<JobCategoryEntity> jobCategoryEntities;

    private List<CommentEntity> commentEntities;

    private List<LikeEntity> likeEntities;

    private List<SubmissionEntity> submissionEntities;
    
    @OneToMany(mappedBy = "projectOfferEntity")
    public List<SubmissionEntity> getSubmissionEntities() {
        return submissionEntities;
    }

    public void setSubmissionEntities(List<SubmissionEntity> submissionEntities) {
        this.submissionEntities = submissionEntities;
    }

    public ProjectOfferEntity () {}

    @Override
    @Column(nullable = false)
    public String getBudget() {
        return super.getBudget();
    }

    @Override
    @Column(nullable = false)
    public String getDeadline() {
        return super.getDeadline();
    }

    @Override
    @Column(nullable = false)
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    @Column(nullable = false)
    public String getDuration() {
        return super.getDuration();
    }

    @Override
    @Column
    public String getLocation() {
        return super.getLocation();
    }

    @Override
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public ProjectOfferStatus getProjectOfferStatus() {
        return super.getProjectOfferStatus();
    }

    @Override
    public void setBudget(String budget) {
        super.setBudget(budget);
    }

    @Override
    public void setDeadline(String deadline) {
        super.setDeadline(deadline);
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public void setDuration(String duration) {
        super.setDuration(duration);
    }

    @Override
    public void setLocation(String location) {
        super.setLocation(location);
    }

    @Override
    public void setProjectOfferStatus(ProjectOfferStatus status) {
        super.setProjectOfferStatus(status);
    }

    @Override
    public String getDatePosted() {
        return super.getDatePosted();
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID getId() {
        return super.getId();
    }

    @Override
    public String getImage() {
        return super.getImage();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public UUID getUserId() {
        return super.getUserId();
    }

    @Override
    public void setDatePosted(String datePosted) {
        super.setDatePosted(datePosted);
    }

    @Override
    public void setId(UUID id) {
        super.setId(id);
    }

    @Override
    public void setImage(String image) {
        super.setImage(image);
    }

    @OneToMany(mappedBy = "projectOfferEntity")
    public List<CommentEntity> getCommentEntities() {
        return commentEntities;
    }

    public void setCommentEntities(List<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }

    @OneToMany(mappedBy = "projectOfferEntity")
    public List<LikeEntity> getLikeEntities() {
        return likeEntities;
    }

    public void setLikeEntities(List<LikeEntity> likeEntities) {
        this.likeEntities = likeEntities;
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public void setUserId(UUID userId) {
        super.setUserId(userId);
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public List<JobCategoryEntity> getJobCategoryEntities() {
        return jobCategoryEntities;
    }

    public void setJobCategoryEntities(List<JobCategoryEntity> jobCategoryEntities) {
        this.jobCategoryEntities = jobCategoryEntities;
    }

    public ProjectOffer toModel() {
        return this;
    }

        public static ProjectOfferEntity from (ProjectOffer projectOffer) {
        ProjectOfferEntity projectOfferEntity = new ProjectOfferEntity();
        projectOfferEntity.setId(projectOffer.getId());
        projectOfferEntity.setTitle(projectOffer.getTitle());
        projectOfferEntity.setDatePosted(projectOffer.getDatePosted());
        projectOfferEntity.setImage(projectOffer.getImage());
        projectOfferEntity.setProjectOfferStatus(projectOffer.getProjectOfferStatus());
        projectOfferEntity.setBudget(projectOffer.getBudget());
        projectOfferEntity.setDeadline(projectOffer.getDeadline());
        projectOfferEntity.setDuration(projectOffer.getDuration());
        projectOfferEntity.setLocation(projectOffer.getLocation());
        projectOfferEntity.setDescription(projectOffer.getDescription());
        
        if (projectOffer.getJobCategories() != null) projectOfferEntity.setJobCategoryEntities(projectOffer.getJobCategories().stream().map(JobCategoryEntity::from).collect(Collectors.toList()));
        return projectOfferEntity;
    }   


}

