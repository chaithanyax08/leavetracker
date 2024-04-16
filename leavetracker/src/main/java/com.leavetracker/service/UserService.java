package com.leavetracker.service;

import com.leavetracker.entity.User;
import com.leavetracker.entity.UserRequest;
import com.leavetracker.exception.UserNotFoundException;
import com.leavetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    public boolean login(String userName, String password) {
//        User user = userRepository.findByUsername(userName);
//        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//            return true;
//        }
//        return false;
//    }
//
//    public void createUser(UserRequest userRequest) {
//        User user = new User();
//        user.setUserId(userRequest.getUserId());
//        user.setUsername(userRequest.getUsername());
//        user.setPassword(userRequest.getPassword());
//        user.setDepartmentId(userRequest.getDepartmentId());
//
//        user.setPhoneNumber(userRequest.getPhoneNumber());
//
//
//
//
//        String encryptedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encryptedPassword);
//
//        userRepository.save(user);
//    }
//
////
////    public void updateUsername(String userId, String username) {
////        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException ("User not found with id: " + userId));
////        user.setUsername(username);
////        userRepository.save(user);
////    }
////
//////    public void updatePassword(String userId, String newPassword) {
//////        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
//////        String encryptedPassword = passwordEncoder.encode(newPassword);
//////        user.setPassword(encryptedPassword);
//////        userRepository.save(user);
//////    }
////public void updatePassword(String userId, String newPassword) {
////    User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
////    String encryptedPassword = passwordEncoder.encode(newPassword);
////    user.setPassword(encryptedPassword);
////    userRepository.saveAndFlush (user);
////}
//
//}
@Autowired
private UserRepository userRepository;

    @Autowired
    private  BCryptPasswordEncoder passwordEncoder;

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            throw new UserNotFoundException("Invalid credentials");
        }
    }
    public User registerUser(UserRequest userRequest) {
        User user = new User();
        user.setUserId(userRequest.getUserId());
        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setDepartmentId(userRequest.getDepartmentId());
        user.setPhoneNumber(userRequest.getPhoneNumber());


        return userRepository.save(user);
    }



    public void updatePassword(String userId, String newPassword) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    public void updateUsername(String userId, String newUsername) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
        user.setUsername(newUsername);
        userRepository.save(user);
    }



    public void deleteUser(String userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
        } else {
            throw new UserNotFoundException("User not found with id: " + userId);
        }
    }
    public User findUserById(String userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new UserNotFoundException("User not found with id: " + userId);
        }
    }
    //Fetch user by id --> it should only includes userId,userName,phoneno,password,departmentName
    public UserRequest fetchUserById(String userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new UserRequest(user.getUserId(), user.getUsername(), user.getDepartmentId(), user.getPhoneNumber());
        } else {
            throw new UserNotFoundException("User not found with id: " + userId);
        }
    }


}
