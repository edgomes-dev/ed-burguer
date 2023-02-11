package com.edburguer.service.impl;

import com.edburguer.dto.UserDto;
import com.edburguer.entity.User;
import com.edburguer.exception.BadRequestException;
import com.edburguer.mapper.UserMapper;
import com.edburguer.repository.UserRepository;
import com.edburguer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User create(UserDto dto) {
        User entity = UserMapper.fromDtoToEntity(dto);

        return userRepository.save(entity);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> entity = userRepository.findById(id);

        if(entity.isEmpty()) throw new BadRequestException("ID inválido");

        return entity.get();
    }
}
