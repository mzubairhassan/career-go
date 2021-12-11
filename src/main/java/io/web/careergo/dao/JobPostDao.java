/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.web.careergo.dao;

import io.web.careergo.entities.AppUser;
import io.web.careergo.entities.JobPost;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author M Zubair Ul Hassan
 */

@Component
public class JobPostDao {
    
    
    @Autowired
    HibernateTemplate hibernateTemplate;
    
    @Transactional
    public String saveJobPost(JobPost jobPost) {
        String i = (String) this.hibernateTemplate.save(jobPost);
        
        return i;
    }
    
   
    
    public List<JobPost> loadAllJobs() {
        List<JobPost> jobs = hibernateTemplate.loadAll(JobPost.class);
        return jobs;
    }
    
    public AppUser getUserById(String id) {
        return hibernateTemplate.get(AppUser.class, id);
    }
    
}
