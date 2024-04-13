package com.leavetracker.dto;

public class UserDTO {
    private String userId;
    private String username;

    private String phoneNumber;

    public UserDTO() {
    }

    public UserDTO(String userId, String username,  String phoneNumber) {
        this.userId = userId;
        this.username = username;
        this.phoneNumber = phoneNumber;
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



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
