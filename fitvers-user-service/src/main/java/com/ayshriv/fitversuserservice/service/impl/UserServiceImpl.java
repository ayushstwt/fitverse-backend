package com.ayshriv.fitversuserservice.service.impl;

import com.ayshriv.fitversuserservice.dtos.RegisterRequest;
import com.ayshriv.fitversuserservice.dtos.UserResponse;
import com.ayshriv.fitversuserservice.entities.User;
import com.ayshriv.fitversuserservice.repositories.UserRepository;
import com.ayshriv.fitversuserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        if (userRepository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("Phone number already exists");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhone(request.getPhone());

        User saveUser = userRepository.save(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setFirstName(saveUser.getFirstName());
        userResponse.setLastName(saveUser.getLastName());
        userResponse.setEmail(saveUser.getEmail());
        userResponse.setPassword(saveUser.getPassword());
        userResponse.setPhone(saveUser.getPhone());
        userResponse.setCreatedOn(saveUser.getCreatedOn());
        userResponse.setUpdatedOn(saveUser.getUpdatedOn());
        return userResponse;
    }

    @Override
    public UserResponse getUserProfile(String userId) {
        User saveUser = userRepository.findById(Long.parseLong(userId)).orElseThrow(() -> new RuntimeException("User not found"));
        UserResponse userResponse = new UserResponse();
        userResponse.setFirstName(saveUser.getFirstName());
        userResponse.setLastName(saveUser.getLastName());
        userResponse.setEmail(saveUser.getEmail());
        userResponse.setPassword(saveUser.getPassword());
        userResponse.setPhone(saveUser.getPhone());
        userResponse.setCreatedOn(saveUser.getCreatedOn());
        userResponse.setUpdatedOn(saveUser.getUpdatedOn());
        return userResponse;
    }
}
