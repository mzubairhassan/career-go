/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.web.careergo.dao;

import com.sun.media.jfxmedia.logging.Logger;
import io.web.careergo.entities.AppUser;
import io.web.careergo.entities.Category;
import io.web.careergo.entities.Skill;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author M Zubair Ul Hassan
 */

@Component
public class CategoryDao {
    
    
    @Autowired
    HibernateTemplate hibernateTemplate;
    
    @Transactional
    public String saveCategory(Category cat) {
        
        String id = (String) hibernateTemplate.save(cat);
        return id;
        
    }
   
    public Category getCatById(String id) {
        System.out.println("asdasdas");
        Category cat = (Category) hibernateTemplate.get(Category.class, id);
        return cat;
        
    }

    @Transactional
    public void saveUser(AppUser us) {
        String id = (String) hibernateTemplate.save(us);
        System.out.println("USer created success + " + id.toString());
        Logger.logMsg(Logger.INFO, "USer created success + " + id.toString());
    }
    public List<Category> loadAll() {
        List<Category> list = (List<Category>) hibernateTemplate.find("from Category cat order by cat.createdAt DESC");
        
        return list;
    }
    
    
    @Transactional
    public String saveSkill(Skill skill) {
        String id = (String) hibernateTemplate.save(skill);
        return id;
        
    }
    
    
    public Skill findSkillById(String id) {
        Skill skill = hibernateTemplate.get(Skill.class, id);
        return skill;
        
    }
    
    
    public List<Skill> findSkillByText(String text) {
        List<Skill> skills =  (List<Skill>) hibernateTemplate.find("from Skill s where skillName = ?0", text);
        
        return skills;
        
    }
    
}
