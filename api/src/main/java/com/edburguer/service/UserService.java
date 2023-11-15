package com.edburguer.service;

import com.edburguer.dto.UserDto;
import com.edburguer.dto.request.SignUpRequest;
import com.edburguer.entity.User;
//import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    User create(UserDto dto);

    List<User> findAll();

    User findById(Long id);

    User update(UserDto dto);

    void delete(Long id);

    void saveAuth(SignUpRequest data);
}
