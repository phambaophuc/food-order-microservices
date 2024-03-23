package com.pbp.authservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class JwtResponse {

    private String accessToken;
    private String refreshToken;
}
