package com.ayshriv.fitversuserservice.service;

import com.ayshriv.fitversuserservice.dto.RegisterRequest;
import com.ayshriv.fitversuserservice.dto.UserResponse;
import jakarta.validation.Valid;

public interface UserService {

    UserResponse register(@Valid RegisterRequest request);

    UserResponse getUserProfile(String userId);

    Boolean existByUserId(long l);
}
