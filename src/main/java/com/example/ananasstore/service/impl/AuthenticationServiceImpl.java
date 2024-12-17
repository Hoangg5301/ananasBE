package com.example.ananasstore.service.impl;

import com.example.ananasstore.dto.requests.AuthenticationRequest;
import com.example.ananasstore.dto.responses.AuthenticationResponse;
import com.example.ananasstore.exception.AppException;
import com.example.ananasstore.exception.ErrorCode;
import com.example.ananasstore.repository.AccountRepository;
import com.example.ananasstore.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthenticationServiceImpl implements AuthenticationService {

    AccountRepository accountRepository;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        var accountEntity = accountRepository.getAccountByUserName(authenticationRequest.getUserName())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        if(!passwordEncoder.matches(authenticationRequest.getPassword(), accountEntity.getPassword())) {
            throw new AppException(ErrorCode.AUTHENTICATION_FAILED);
        } else{

        }
        return null;
    }
}
