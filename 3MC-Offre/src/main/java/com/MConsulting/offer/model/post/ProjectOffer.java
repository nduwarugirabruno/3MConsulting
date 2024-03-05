package com.MConsulting.offer.model.post;

import java.util.List;
import java.util.UUID;

import com.MConsulting.offer.model.category.JobCategory;

public class ProjectOffer extends Post{

    private ProjectOfferStatus projectOfferStatus;

    private String description;

    private String location;

    private String duration;

    private String deadline;

    private String budget;

    private List<JobCategory> jobCategories;

    public ProjectOffer() {
    }

    public ProjectOffer(UUID id, String title, String datePosted, String image, ProjectOfferStatus status, String description, String location, String duration, String deadline, String budget, UUID userId) {
        super(id, title, datePosted, image, userId);
        this.projectOfferStatus = status;
        this.description = description;
        this.location = location;
        this.duration = duration;
        this.deadline = deadline;
        this.budget = budget;
    }

    public List<JobCategory> getJobCategories() {
        return jobCategories;
    }

    public void setJobCategories(List<JobCategory> jobCategories) {
        this.jobCategories = jobCategories;
    }



    public ProjectOfferStatus getProjectOfferStatus() {
        return projectOfferStatus;
    }

    public void setProjectOfferStatus(ProjectOfferStatus status) {
        this.projectOfferStatus = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    
}
