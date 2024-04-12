package com.leavetracker.entity;


import java.time.LocalDateTime;
import java.util.Date;

public class UserRequest {
    private String userId;
    private String username;
    private String password;
    private int departmentId;

    private String phoneNumber;



    public UserRequest(String userId, String username, String password, int departmentId, String phoneNumber) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.departmentId = departmentId;
        this.phoneNumber = phoneNumber;

    }

    public UserRequest() {
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
