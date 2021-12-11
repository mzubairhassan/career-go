/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.web.careergo.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author M Zubair Ul Hassan
 */
@Entity
public class Application {

    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "jobpost_id",
            foreignKey = @ForeignKey(name = "JOB_ID_FK")
    )
    private JobPost jobPostId;

    @ManyToOne
    @JoinColumn(name = "applicant_id",
            foreignKey = @ForeignKey(name = "APPLICANT_ID_FK")
    )
    private ApplicantProfile applicantId;

    @CreationTimestamp
    private Date createdAt;
    
    private String progress;

    public Application() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JobPost getJobPostId() {
        return jobPostId;
    }

    public void setJobPostId(JobPost jobPostId) {
        this.jobPostId = jobPostId;
    }

    public ApplicantProfile getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(ApplicantProfile applicantId) {
        this.applicantId = applicantId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
    
    
    
    
}
