/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.web.careergo.utils;

import io.web.careergo.entities.AppUser;
import io.web.careergo.entities.Category;
import io.web.careergo.entities.JobPost;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 *
 * @author M Zubair Ul Hassan
 */
public class JobPostUIObject extends JobPost{
    
    private String skillText;
    private String categoryId;
    private String q1,q2,q3;
    private String q1Type, q2Type,q3Type;

    public String getSkillText() {
        return skillText;
    }

    public void setSkillText(String skillText) {
        this.skillText = skillText;
            
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public String getQ1Type() {
        return q1Type;
    }

    public void setQ1Type(String q1Type) {
        this.q1Type = q1Type;
    }

    public String getQ2Type() {
        return q2Type;
    }

    public void setQ2Type(String q2Type) {
        this.q2Type = q2Type;
    }

    public String getQ3Type() {
        return q3Type;
    }

    public void setQ3Type(String q3Type) {
        this.q3Type = q3Type;
    }



    public JobPostUIObject() {
        
    }

    @Override
    public String toString() {
        return "'skills':'" + getReqSkills()
                + "', 'jobTitle': '"+ getJobTitle()
                + "', 'jobDesc':'" + getJobDesc()
                + "', 'careerLevel':'" + getCareerLevel()
                + "', 'noOfPos':'" + getNoOfPos()
                + "', 'yearOfExp':'" + getYearOfExp()
                + "', 'salary':'" + getSalary()
                + "', 'empType':'" + getEmpType()
                + "', 'datePosted':'" + getDatePosted().toString()
                + "', 'cateogry':'" + getCatId().getCatName()
                + "', 'user':'" + getPostedBy().getUsername()
                + "'"
                ;
    }


    
    
    
    
}
