package com.example.ananasstore.service;

import com.example.ananasstore.dto.requests.AuthenticationRequest;
import com.example.ananasstore.dto.requests.ValidTokenRequest;
import com.example.ananasstore.dto.responses.AuthenticationResponse;
import com.example.ananasstore.dto.responses.ValidTokenResponse;

public interface AuthenticationService {
    ValidTokenResponse verifyToken(ValidTokenRequest validTokenRequest);
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
