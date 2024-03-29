package com.edburguer.resource;

import com.edburguer.dto.request.SignInRequest;
import com.edburguer.dto.request.SignUpRequest;
import com.edburguer.entity.User;
import com.edburguer.service.UserService;
import com.edburguer.service.impl.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticaionResource {
    @Autowired
    private UserService service;

    @Autowired
    private TokenServiceImpl tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid SignInRequest data) throws Exception {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword());

        try {
            var auth = authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken((User) auth.getPrincipal());

            return ResponseEntity.ok(token);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid SignUpRequest data) {
        service.saveAuth(data);

        return ResponseEntity.ok().build();
    }
}
