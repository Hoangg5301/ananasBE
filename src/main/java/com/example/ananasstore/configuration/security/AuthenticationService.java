package com.example.ananasstore.configuration.security;

import com.example.ananasstore.dto.requests.AuthenticationRequest;
import com.example.ananasstore.dto.responses.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
