package com.leavetracker.dto;

public class UserDTO {
    private String userId;
    private String username;
    private String phoneNumber;
    private String departmentName;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDTO() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public UserDTO(String userId, String username, String phoneNumber, String departmentName ,String password) {
        this.userId = userId;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.departmentName = departmentName;
        this.password = password ;
    }
}
