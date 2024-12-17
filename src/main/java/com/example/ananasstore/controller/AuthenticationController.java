package com.example.ananasstore.controller;

import com.example.ananasstore.dto.ResponseAPI;
import com.example.ananasstore.dto.requests.AuthenticationRequest;
import com.example.ananasstore.dto.responses.AuthenticationResponse;
import com.example.ananasstore.service.AuthenticationService;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    public ResponseAPI<AuthenticationResponse> login(AuthenticationRequest authenticationRequest) {
        return null;
    }

}
