package com.edburguer.service;

import com.edburguer.dto.request.SignInRequest;
import com.edburguer.dto.request.SignUpRequest;
import com.edburguer.dto.response.JwtAuthenticationResponse;

public interface AuthenticatinService {
    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signin(SignInRequest request);
}
