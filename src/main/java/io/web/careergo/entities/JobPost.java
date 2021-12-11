/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.web.careergo.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

/**
 *
 * @author M Zubair Ul Hassan
 */

@Entity
public class JobPost {
    
    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;
    
    private String jobTitle;
    private String jobDesc;
    
    @Column(columnDefinition="TEXT")
    private String reqSkills;

    private String careerLevel;
    private int noOfPos;
    private float yearOfExp;
    private int salary;
    private String empType;
    private String questionares;
    @CreationTimestamp
    private Date datePosted;
    
    
    
    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "JOB_POSTED_BY_USER_ID_FK")
    )
    private AppUser postedBy;
    
    @ManyToOne
    @JoinColumn(name = "cat_id",
            foreignKey = @ForeignKey(name = "JOB_POST_CAT_ID_FK")
    )
    private Category catId;
    
    public JobPost(){
        
    }


    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = new Date();
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

   
    public String getCareerLevel() {
        return careerLevel;
    }

    public void setCareerLevel(String careerLevel) {
        this.careerLevel = careerLevel;
    }

    public int getNoOfPos() {
        return noOfPos;
    }

    public void setNoOfPos(int noOfPos) {
        this.noOfPos = noOfPos;
    }

    public float getYearOfExp() {
        return yearOfExp;
    }

    public void setYearOfExp(float yearOfExp) {
        this.yearOfExp = yearOfExp;
    }

    

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

 

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Category getCatId() {
        return catId;
    }

    public void setCatId(Category catId) {
        this.catId = catId;
    }

    public AppUser getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(AppUser postedBy) {
        this.postedBy = postedBy;
    }

    public String getReqSkills() {
        return reqSkills;
    }

    public void setReqSkills(String reqSkills) {
        this.reqSkills = reqSkills;
    }

    public String getQuestionares() {
        return questionares;
    }

    public void setQuestionares(String questionares) {
        this.questionares = questionares;
    }
    
    

    
    
    
    
    
}
