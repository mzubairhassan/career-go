/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.web.careergo;

import io.web.careergo.entities.JobPost;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 *
 * @author M Zubair Ul Hassan
 */
public class ContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<JobPost> jobs = new ArrayList<JobPost>();
        ServletContext context = sce.getServletContext();
        context.setAttribute("jobs", jobs);
        System.out.println("Context initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Contxt Destroyed");
    }

    
}
