package com.example.ananasstore.service.impl;

import com.example.ananasstore.dto.requests.AuthenticationRequest;
import com.example.ananasstore.dto.requests.ValidTokenRequest;
import com.example.ananasstore.dto.responses.AuthenticationResponse;
import com.example.ananasstore.dto.responses.ValidTokenResponse;
import com.example.ananasstore.exception.AppException;
import com.example.ananasstore.exception.ErrorCode;
import com.example.ananasstore.repository.AccountRepository;
import com.example.ananasstore.service.AuthenticationService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthenticationServiceImpl implements AuthenticationService {

    @NonFinal
    @Value("${jwt.key}")
    protected String SIGNER_KEY;
    AccountRepository accountRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public ValidTokenResponse verifyToken(ValidTokenRequest validTokenRequest) {
//        try {
//            JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());
//            SignedJWT signedJWT = SignedJWT.parse(validTokenRequest.getToken());
//            boolean verified = signedJWT.verify(verifier);
//            Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();
//            return new ValidTokenResponse(verified && expiryTime.after(new Date()));
//        } catch (JOSEException | ParseException e) {
//            throw new RuntimeException(e);
//        }
        return null;
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        var accountEntity = accountRepository.getAccountByUserName(authenticationRequest.getUserName())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        if (!passwordEncoder.matches(authenticationRequest.getPassword(), accountEntity.getPassword())) {
            throw new AppException(ErrorCode.AUTHENTICATION_FAILED);
        }

        String token = generateToken(authenticationRequest.getUserName());
        return AuthenticationResponse.builder()
                .token(token)
                .authenticated(true)
                .build();
    }

    private String generateToken(String userName) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(userName)
                .issuer("annanas.vn")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(10, ChronoUnit.DAYS).toEpochMilli()
                ))
                .claim("Custom", "hoangnv")
                .build();

        //create payload
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(header, payload);
        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException exception) {
            throw new RuntimeException("Cannot create JWT object", exception);
        }
    }
}
