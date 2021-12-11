/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.web.careergo.entities;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author M Zubair Ul Hassan
 */
@Entity
public class Skill {
    
    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id")
    private String id;
    
    private String skillName;
    private String skillDesc;
    
    @ManyToOne
	@JoinColumn(name = "cat_id",
			foreignKey = @ForeignKey(name = "CATEGORY_ID_FK")
	)
    private Category catId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDesc() {
        return skillDesc;
    }

    public void setSkillDesc(String skillDesc) {
        this.skillDesc = skillDesc;
    }

    public Category getCatId() {
        return catId;
    }

    public void setCatId(Category catId) {
        this.catId = catId;
    }

    public Skill(String skillName, String skillDesc, Category catId) {
        this.skillName = skillName;
        this.skillDesc = skillDesc;
        this.catId = catId;
    }

   


    public Skill() {
    }
    
    
    
}
