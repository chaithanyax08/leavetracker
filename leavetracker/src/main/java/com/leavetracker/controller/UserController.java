package com.leavetracker.controller;

import com.leavetracker.dto.UserDTO;
import com.leavetracker.entity.User;
import com.leavetracker.entity.UserRequest;
import com.leavetracker.service.UserNotFoundException;
import com.leavetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //User Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginUser) {
        boolean isAuthenticated = userService.login(loginUser.getUserId(), loginUser.getPassword());
        if (isAuthenticated) {
            return new ResponseEntity<>("Login successful!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials!", HttpStatus.UNAUTHORIZED);
        }
    }

    //Create(add) new user
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest) {
        try {
            userService.createUser (userRequest);
            return ResponseEntity.ok ("User created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status (HttpStatus.INTERNAL_SERVER_ERROR).body ("Error creating user: " + e.getMessage ());
        }
    }

  //Delete user based on id(Logout)
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


    //Update(set new password) user password based on id
    @PutMapping("/updatePassword/{userId}")

    public ResponseEntity<String> updatePassword(@PathVariable String userId,@RequestBody String password) {
        try {

            userService.findUserById(userId);
            userService.updatePassword(userId,password);
            return ResponseEntity.ok("User password updated successfully.");
        }
        catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + userId);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user: " + e.getMessage());
        }
    }

    //update username based on id
    @PutMapping("/updateName/{userId}")

    public ResponseEntity<String> updateUsername(@PathVariable String userId,@RequestBody String username) {
        try {

            userService.findUserById(userId);
            userService.updateUsername(userId,username);
            return ResponseEntity.ok("Username updated successfully.");
        }
        catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + userId);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user: " + e.getMessage());
        }
    }

    //fetch only required details(id,name,phonenumber,department,password)for profile by using id
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String userId) {
        try {
            UserDTO userDTO = userService.fetchUserById(userId);
            return ResponseEntity.ok(userDTO);
        }
        catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }



}
