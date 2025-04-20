package com.ayshriv.fitversuserservice.service;

import com.ayshriv.fitversuserservice.dtos.RegisterRequest;
import com.ayshriv.fitversuserservice.dtos.UserResponse;
import jakarta.validation.Valid;

public interface UserService {

    UserResponse register(@Valid RegisterRequest request);

    UserResponse getUserProfile(String userId);
}
