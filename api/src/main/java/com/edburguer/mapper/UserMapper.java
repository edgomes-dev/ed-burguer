package com.edburguer.mapper;

import com.edburguer.dto.UserDto;
import com.edburguer.entity.Role;
import com.edburguer.entity.User;

public class UserMapper {
    public static User fromDtoToEntity(UserDto dto) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .password(dto.getPassword())
                .role(Role.USER)
                .build();
    }
}
