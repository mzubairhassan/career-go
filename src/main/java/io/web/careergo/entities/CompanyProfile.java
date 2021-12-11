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
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author M Zubair Ul Hassan
 */
@Entity
public class CompanyProfile {

    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    private int age;
    private int manSize;
    private String location;

    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "COMP_PROF_USER_ID_FK")
    )
    private AppUser userId;

    @ManyToOne
    @JoinColumn(name = "cat_id",
            foreignKey = @ForeignKey(name = "COMP_PROF_CATEGORY_ID_FK")
    )
    private Category catId;
    
    @CreationTimestamp
    private Date createdAt;

    public CompanyProfile(int age, int manSize, String location, AppUser userId, Category catId) {
        this.age = age;
        this.manSize = manSize;
        this.location = location;
        this.userId = userId;
        this.catId = catId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getManSize() {
        return manSize;
    }

    public void setManSize(int manSize) {
        this.manSize = manSize;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public AppUser getUserId() {
        return userId;
    }

    public void setUserId(AppUser userId) {
        this.userId = userId;
    }

    public Category getCatId() {
        return catId;
    }

    public void setCatId(Category catId) {
        this.catId = catId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public CompanyProfile() {
    }
    
    
    
    

}
