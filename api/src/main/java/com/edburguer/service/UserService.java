package com.edburguer.service;

import com.edburguer.dto.UserDto;
import com.edburguer.entity.User;

public interface UserService {
    User create(UserDto dto);
}
