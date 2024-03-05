package com.MConsulting.offer.model.submission;

import java.util.UUID;

public class JobSubmission extends Submission{

    private JobSubmissionStatus jobSubmissionStatus;

    private String message;

    public JobSubmission() {}
    
    public JobSubmission(UUID id, JobSubmissionStatus jobSubmissionStatus, String message) {
        super(id);
        this.jobSubmissionStatus = jobSubmissionStatus;
        this.message = message;
    }

    public JobSubmissionStatus getJobSubmissionStatus() {
        return jobSubmissionStatus;
    }

    public void setJobSubmissionStatus(JobSubmissionStatus jobSubmissionStatus) {
        this.jobSubmissionStatus = jobSubmissionStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
}
