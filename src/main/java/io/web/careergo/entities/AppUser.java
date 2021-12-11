        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.web.careergo.entities;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author M Zubair Ul Hassan
 */

@Entity
public class AppUser {
    
    
    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;
    
    private String username;
    private String email;
    private String password;
    private String userType;
    private String address;
    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeration;

    public AppUser() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegisteration() {
        return registeration;
    }

    public void setRegisteration(Date registeration) {
        this.registeration = registeration;
    }

    public AppUser(String username, String email, String password, String userType, String address) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.address = address;
    }

    @Override
    public String toString() {
        return "AppUser{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", userType=" + userType + ", address=" + address + ", registeration=" + registeration + '}';
    }
    
    
    
}


