package com.example.ananasstore.service;

import com.example.ananasstore.dto.requests.AuthenticationRequest;
import com.example.ananasstore.dto.responses.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
