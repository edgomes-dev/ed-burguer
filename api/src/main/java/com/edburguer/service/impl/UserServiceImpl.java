package com.edburguer.service.impl;

import com.edburguer.dto.UserDto;
import com.edburguer.dto.request.SignUpRequest;
import com.edburguer.entity.Role;
import com.edburguer.entity.User;
import com.edburguer.exception.BadRequestException;
import com.edburguer.exception.NotFoundException;
import com.edburguer.mapper.UserMapper;
import com.edburguer.repository.UserRepository;
import com.edburguer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    @Override
    public User update(UserDto dto) {
        User entity = findById(dto.getId());

        if(Objects.isNull(entity)) throw new NotFoundException("User não encontrado");

        return userRepository.save(UserMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Long id) {
        User entity = findById(id);

        if(Objects.isNull(entity)) throw new NotFoundException("User não encontrado");

        userRepository.deleteById(entity.getId());
    }

    @Override
    public void saveAuth(SignUpRequest data) {
        if(userRepository.findByEmail(data.getEmail()) != null) throw new BadRequestException("Usário com esse e-mail já existe");

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        User newUser = new User();
        newUser.setName(data.getName());
        newUser.setEmail(data.getEmail());
        newUser.setPhone(data.getPhone());
        newUser.setPassword(encryptedPassword);
        newUser.setRole(Role.USER);

        userRepository.save(newUser);
    }
}
