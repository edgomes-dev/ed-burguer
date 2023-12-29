package com.edburguer.dto;

import com.edburguer.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String password;

    private Role role;
}
