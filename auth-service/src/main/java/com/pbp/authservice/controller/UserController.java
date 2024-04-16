package com.pbp.authservice.controller;

import com.pbp.authservice.dto.request.LoginRequest;
import com.pbp.authservice.dto.request.SignupRequest;
import com.pbp.authservice.dto.response.MessageResponse;
import com.pbp.authservice.exception.EmailAlreadyException;
import com.pbp.authservice.exception.UsernameAlreadyException;
import com.pbp.authservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<MessageResponse> register(@Valid @RequestBody SignupRequest signupRequest) {
        try {
            return new ResponseEntity<>(userService.register(signupRequest), HttpStatus.CREATED);
        } catch (UsernameAlreadyException e) {
            return new ResponseEntity<>(new MessageResponse("User already registered!"), HttpStatus.BAD_REQUEST);
        } catch (EmailAlreadyException e) {
            return new ResponseEntity<>(new MessageResponse("Email already registered!"), HttpStatus.BAD_REQUEST);
        }
    }
}
