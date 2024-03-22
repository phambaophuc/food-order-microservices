package com.pbp.authservice.service;

import com.pbp.authservice.dto.request.LoginRequest;
import com.pbp.authservice.dto.request.SignupRequest;
import com.pbp.authservice.dto.response.JwtResponse;
import com.pbp.authservice.dto.response.MessageResponse;

public interface UserService {

    JwtResponse signin(LoginRequest loginRequest);

    MessageResponse signup(SignupRequest signupRequest);
}
