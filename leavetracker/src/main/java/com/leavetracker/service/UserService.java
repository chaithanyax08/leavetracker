package com.leavetracker.service;

import com.leavetracker.entity.User;
import com.leavetracker.entity.UserRequest;
import com.leavetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean login(String userName, String password) {
        User user = userRepository.findByUsername(userName);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return true;
        }
        return false;
    }

    public void createUser(UserRequest userRequest) {
        User user = new User();
        user.setUserId(userRequest.getUserId());
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setDepartmentId(userRequest.getDepartmentId());

        user.setPhoneNumber(userRequest.getPhoneNumber());




        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        userRepository.save(user);
    }
}
