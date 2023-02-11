package com.edburguer.service;

import com.edburguer.dto.UserDto;
import com.edburguer.entity.User;

import java.util.List;

public interface UserService {
    User create(UserDto dto);

    List<User> findAll();

    User findById(Long id);
}
