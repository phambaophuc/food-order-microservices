package com.pbp.authservice.service;

import com.pbp.authservice.dto.request.LoginRequest;
import com.pbp.authservice.dto.request.SignupRequest;
import com.pbp.authservice.dto.response.JwtResponse;

public interface UserService {

    JwtResponse login(LoginRequest loginRequest);

    void register(SignupRequest signupRequest);
}
