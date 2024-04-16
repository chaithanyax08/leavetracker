
package com.leavetracker.controller;

import com.leavetracker.entity.User;
import com.leavetracker.entity.UserRequest;
import com.leavetracker.exception.UserNotFoundException;
import com.leavetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest userRequest) {
        try {
            User authenticatedUser = userService.login(userRequest.getUsername(), userRequest.getPassword());
            return ResponseEntity.ok("User logged in successfully!");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials!");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequest userRequest) {
        try {
            User registeredUser = userService.registerUser (userRequest);
            return ResponseEntity.ok (registeredUser);
        } catch (Exception e) {
            return ResponseEntity.status (HttpStatus.INTERNAL_SERVER_ERROR).body ("Error registering user: " + e.getMessage ());
        }
    }



    @PutMapping("/{userId}/password")
    public ResponseEntity<String> updatePassword(@PathVariable String userId, @RequestParam String newPassword) {
        try {
            userService.updatePassword(userId, newPassword);
            return ResponseEntity.ok("Password updated successfully");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{userId}/username")
    public ResponseEntity<String> updateUsername(@PathVariable String userId, @RequestParam String newUsername) {
        try {
            userService.updateUsername(userId, newUsername);
            return ResponseEntity.ok("Username updated successfully");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        try {
            // Check if the user exists before attempting deletion
            userService.findUserById(userId);
            userService.deleteUser(userId);
            return ResponseEntity.ok("User deleted successfully.");
        }
        catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + userId);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user: " + e.getMessage());
        }
    }
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable String userId) {
        try {
            UserRequest userRequest = userService.fetchUserById(userId);
            return ResponseEntity.ok(userRequest);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



}