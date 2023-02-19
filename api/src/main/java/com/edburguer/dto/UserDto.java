package com.edburguer.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserDto {
    private Long id;

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String password;

    private Boolean administrator;
}
