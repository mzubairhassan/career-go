/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.web.careergo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author M Zubair Ul Hassan
 */

@Controller
public class AdminController {
    
    @RequestMapping("/admin-home")
    public String adminPage(){
        return "admin/admin-home";
    }
    
}
