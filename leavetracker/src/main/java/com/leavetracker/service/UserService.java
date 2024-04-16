package com.leavetracker.service;

import com.leavetracker.dto.UserDTO;
import com.leavetracker.entity.Department;
import com.leavetracker.entity.User;
import com.leavetracker.entity.UserRequest;
import com.leavetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //Login
    public boolean login(String userId, String password) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return true; // Passwords match
            }
        }
        return false; // Invalid credentials
    }

    //Create User
    public void createUser(UserRequest userRequest) {
        User user = new User();
        user.setUserId(userRequest.getUserId());
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
    }

    //Delete user based on id(Logout)
    public void deleteUser(String userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
        } else {
            throw new UserNotFoundException("User not found with id: " + userId);
        }
    }

    //Find user based on id
    public User findUserById(String userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new UserNotFoundException("User not found with id: " + userId);
        }
    }

    //Fetch user by id --> it should only includes userId,userName,phoneno,password,departmentName
    public UserDTO fetchUserById(String userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Department department = user.getDepartment();
            String departmentName = (department != null) ? department.getDepartmentName() : null;

            return new UserDTO(user.getUserId(), user.getUsername(),  user.getPhoneNumber() ,departmentName , user.getPassword());
        } else {
            throw new UserNotFoundException("User not found with id: " + userId);
        }
    }


    //Update(set new password) user password based on id
    public void updatePassword(String userId, String password) throws UserNotFoundException {
        // Retrieve the user from the repository
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Encode the new password
            String encryptedPassword = passwordEncoder.encode(password);
            user.setPassword(encryptedPassword);
            userRepository.save(user);
        }

        else {
            throw new UserNotFoundException("User not found with id: " + userId);
        }
    }

    //Update name based on id
    public void updateUsername(String userId, String username) throws UserNotFoundException {
        // Retrieve the user from the repository
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUsername(username);
            userRepository.save(user);
        }

        else {
            throw new UserNotFoundException("User not found with userName: " + username);
        }
    }

}
