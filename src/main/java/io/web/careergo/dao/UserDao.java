/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.web.careergo.dao;

import io.web.careergo.entities.AppUser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author M Zubair Ul Hassan
 */

@Component
public class UserDao {
    
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    @Transactional
    public String saveUser(AppUser user) {
        String id = (String) hibernateTemplate.save(user);
        return id;
    }
    
    public AppUser getUser(String id) {
        AppUser user = hibernateTemplate.get(AppUser.class, id);
        return user;
    }
    
}
