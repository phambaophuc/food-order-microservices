package com.pbp.authservice.utils;

import com.pbp.authservice.dto.UserDto;
import com.pbp.authservice.entity.User;

public interface UserMapper {

    static UserDto mapToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .roles(user.getRoles())
                .build();
    }
}
