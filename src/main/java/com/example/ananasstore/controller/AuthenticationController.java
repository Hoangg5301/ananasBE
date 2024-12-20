package com.example.ananasstore.controller;

import com.example.ananasstore.dto.ResponseAPI;
import com.example.ananasstore.dto.requests.AuthenticationRequest;
import com.example.ananasstore.dto.requests.ValidTokenRequest;
import com.example.ananasstore.dto.responses.AuthenticationResponse;
import com.example.ananasstore.dto.responses.ValidTokenResponse;
import com.example.ananasstore.service.AuthenticationService;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/")
    public ResponseAPI<ValidTokenResponse> verifyToken(@RequestBody ValidTokenRequest validTokenRequest) {
        return new ResponseAPI<ValidTokenResponse>(HttpStatus.OK, "verify successfully!",authenticationService.verifyToken(validTokenRequest));
    }
    @PostMapping("/login")
    public ResponseAPI<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(authenticationRequest);
        return new ResponseAPI<>(HttpStatus.OK, "Authentication Successful", authenticationResponse);
    }

}
