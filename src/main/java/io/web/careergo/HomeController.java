/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.web.careergo;

import io.web.careergo.dao.CategoryDao;
import io.web.careergo.dao.JobPostDao;
import io.web.careergo.dao.UserDao;
import io.web.careergo.entities.AppUser;
import io.web.careergo.entities.Category;
import io.web.careergo.entities.JobPost;
import io.web.careergo.utils.JobPostUIObject;
import io.web.careergo.utils.UtilityFunctions;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author M Zubair Ul Hassan
 */
@Controller
public class HomeController {

    @Autowired
    ServletContext ctx;

    @Autowired
    JobPostDao jobPostDao;

    @Autowired
    CategoryDao catDao;

    @Autowired
    UserDao userDao;

    @Autowired
    UtilityFunctions utiltFuncs;

    @RequestMapping("/")
    public String home(Model m) {
        return "home";
    }

    @RequestMapping("about/{ifd}/api/web")
    public String about(@PathVariable("ifd") String ifd, Model m) {
        m.addAttribute("name", ifd);
        System.out.println("asdasddassssssss::" + ifd);
        return "about";
    }

    @RequestMapping("register")
    public String registerPage(Model m) {
        m.addAttribute("appUser", new AppUser());
        return "user/userRegister";
    }

    @RequestMapping("saveUser")
    public String about(@ModelAttribute("appUser") AppUser appUser) {
        String id = userDao.saveUser(appUser);
        return "redirect:/login/" + id;
    }

    @RequestMapping("login/{id}")
    public String login(@PathVariable("id") String id, Model m) {
        AppUser user = userDao.getUser(id);
        System.out.println("user: " + user.getUsername());

        m.addAttribute("userName", user.getUsername());
        return "user/login";
    }

    @RequestMapping("postJob")
    public String postJob(Model m) {
        m.addAttribute("cats", catDao.loadAll());
        m.addAttribute("jobPostUiObj", new JobPostUIObject());
        
        
        return "addJobPost";
    }

    @RequestMapping("viewJobs")
    public String viewJobs(Model m) {
//        AppUser us = new AppUser("mzubair", "mzubair@gmail.com", "password", "company", "amf kamra");
//        catDao.saveUser(us);
////        List<JobPost> jobs = (List<JobPost>) ctx.getAttribute("jobs");
        List<JobPostUIObject> jobs = utiltFuncs.getUIJobPost(jobPostDao.loadAllJobs());
        
        System.out.println("cat" +jobPostDao.loadAllJobs().get(0).getCatId());
        
        m.addAttribute("jobs",jobs);
        return "viewJobs";
    }

    @RequestMapping(value="saveJobPost", method = RequestMethod.POST)
    public String saveJobPost(@ModelAttribute("catform") JobPostUIObject jobPost, Model m) {
        
        JobPost finalJobToSave = this.utiltFuncs.getJobPost(jobPost);;
        
        
       jobPostDao.saveJobPost(finalJobToSave);
        return "redirect:/viewJobs";
    }

    @RequestMapping("admin/categories")
    public String categories(Model m) {
//     
        m.addAttribute("catform", new Category());
        m.addAttribute("cats", catDao.loadAll());
        return "admin/categories";
    }
    @RequestMapping("admin/saveCategory")
    public String saveCategory(@ModelAttribute("catform") Category cat ,Model m) {
//        
        String id = catDao.saveCategory(cat);
        m.addAttribute("savedCat", id);
        return "redirect:/admin/categories";
    }
    
    
    
    @RequestMapping("dumbSave")
    public String mindIt(Model m) {
//        
        Category cat = catDao.getCatById("26d3c528-8da2-4957-bc65-de82bc651c41");
        System.out.println("asdas" + cat.getCatName());
        return "testingform";
    }
}
