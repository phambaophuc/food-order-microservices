package com.pbp.authservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SignupRequest {

    @NotBlank
    @Size(min = 3, max = 128)
    private String username;

    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 128)
    private String password;

    private Set<String> roles;
}
