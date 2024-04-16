package com.leavetracker.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tblusers")
public class User {

@Id
    @Column(name = "userid")
    private String userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "fk_departmentid")
    private int departmentId;

    @Column(name = "isadmin")
    private int isAdmin;

    @Column(name = "isactive")
    private int isActive;

    @Column(name = "phoneno")
    private String phoneNumber;

    @Column(name = "fk_createduserid")
    private String createdUserId;

    @Column(name = "profilephoto")
    private String profilePhoto;

    @Column(name = "created_datetime")
    private Date createdDateTime;

    // Constructors, getters, and setters

    public User() {
    }

    public User(String userId, String username, String password, int departmentId, int isAdmin, int isActive, String phoneNumber, String createdUserId, String profilePhoto, Date createdDateTime) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.departmentId = departmentId;
        this.isAdmin = isAdmin;
        this.isActive = isActive;
        this.phoneNumber = phoneNumber;
        this.createdUserId = createdUserId;
        this.profilePhoto = profilePhoto;
        this.createdDateTime = createdDateTime;
    }

    // Getters and setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}