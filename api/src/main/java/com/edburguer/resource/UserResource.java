package com.edburguer.resource;

import com.edburguer.dto.UserDto;
import com.edburguer.entity.User;
import com.edburguer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserResource {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody UserDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        userService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
