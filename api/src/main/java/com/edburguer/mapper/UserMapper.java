package com.edburguer.mapper;

import com.edburguer.dto.UserDto;
import com.edburguer.entity.User;

public class UserMapper {
    public static User fromDtoToEntity(UserDto dto) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(dto.getRole())
                .build();
    }
}
