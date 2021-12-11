/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.web.careergo.utils;

import io.web.careergo.dao.CategoryDao;
import io.web.careergo.dao.JobPostDao;
import io.web.careergo.entities.AppUser;
import io.web.careergo.entities.Category;
import io.web.careergo.entities.JobPost;
import io.web.careergo.entities.Skill;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author M Zubair Ul Hassan
 */
@Service
public class UtilityFunctions {

    @Autowired
    CategoryDao catDao;
    @Autowired
    JobPostDao jobPostDao;

    public JobPost getJobPost(JobPostUIObject job) {
        JobPost jobPostFinal = new JobPost();

        jobPostFinal.setCareerLevel(job.getCareerLevel());
        jobPostFinal.setEmpType(job.getEmpType());
        jobPostFinal.setJobDesc(job.getJobDesc());
        jobPostFinal.setJobTitle(job.getJobTitle());
        jobPostFinal.setNoOfPos(job.getNoOfPos());
        jobPostFinal.setSalary(job.getSalary());
        jobPostFinal.setYearOfExp(job.getYearOfExp());
        jobPostFinal.setCatId(catDao.getCatById(job.getCategoryId()));
        String[] skillString = job.getSkillText().split(",");

        List<String> skillsArr = Arrays.asList(skillString);

        List<Skill> dbSkills = null;
        Skill newSkill;
        StringBuilder requiredSkills = new StringBuilder();
        List<Skill> finalSkills = new ArrayList<Skill>();

        for (String skill : skillsArr) {
            dbSkills = catDao.findSkillByText(skill);

            if (Objects.isNull(dbSkills) || dbSkills.size() <= 0) {
                String catiiid = job.getCategoryId();
                Category catObj = catDao.getCatById(catiiid);
                Skill newDbSKill = new Skill(skill, skill, catObj);
                String skillIDD = catDao.saveSkill(newDbSKill);

                newSkill = catDao.findSkillById(skillIDD);
                requiredSkills.append(newSkill.getId());
                requiredSkills.append(",");

            } else {
                finalSkills.add(dbSkills.get(0));
                requiredSkills.append(dbSkills.get(0).getId());
                requiredSkills.append(",");
            }
        }

        jobPostFinal.setReqSkills(requiredSkills.substring(0, requiredSkills.length() - 1).toString());
        jobPostFinal.setPostedBy(jobPostDao.getUserById("2b8fe38e-eb4f-4bf9-b4b9-823900194eb9"));

        return jobPostFinal;
    }

    public List<JobPostUIObject> getUIJobPost(List<JobPost> jobs) {
        JobPostUIObject jobPostFinal;
        List<JobPostUIObject> finalJobs = new ArrayList<JobPostUIObject>();
        String[] skillIds;
        Category catF = new Category();
        Date jobPosted = new Date();
        AppUser user = new AppUser();
        StringBuilder skillNames = new StringBuilder();
        for (JobPost job : jobs) {
            jobPostFinal = new JobPostUIObject();
            jobPostFinal.setCareerLevel(job.getCareerLevel());
            jobPostFinal.setEmpType(job.getEmpType());
            jobPostFinal.setJobDesc(job.getJobDesc());
            jobPostFinal.setJobTitle(job.getJobTitle());
            jobPostFinal.setNoOfPos(job.getNoOfPos());
            jobPostFinal.setSalary(job.getSalary());
            jobPostFinal.setYearOfExp(job.getYearOfExp());
            catF = job.getCatId(); 
            jobPosted = job.getDatePosted();
            user = job.getPostedBy();
            jobPostFinal.setDatePosted(jobPosted);
            jobPostFinal.setCatId(catF);
            jobPostFinal.setPostedBy(user); // ( 15 card receive 14, 2 card new )
            
            skillIds = job.getReqSkills().split(",");
            
            for(String skillId: skillIds) {
                skillNames.append(catDao.findSkillById(skillId).getSkillName()).append(",");
            }
            
            jobPostFinal.setReqSkills(skillNames.substring(0, skillNames.length() - 1).toString());
            
            finalJobs.add(jobPostFinal);
        }
        return finalJobs;
    }

}
