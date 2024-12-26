package com.example.ananasstore.configuration.security;

import com.example.ananasstore.dto.requests.AuthenticationRequest;
import com.example.ananasstore.dto.requests.ValidTokenRequest;
import com.example.ananasstore.dto.responses.AuthenticationResponse;
import com.example.ananasstore.dto.responses.ValidTokenResponse;
import com.example.ananasstore.entity.AccountEntity;
import com.example.ananasstore.exception.AppException;
import com.example.ananasstore.exception.ErrorCode;
import com.example.ananasstore.repository.AccountRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthenticationServiceImpl implements AuthenticationService {
    AccountRepository accountRepository;
    PasswordEncoder passwordEncoder;
    JWTUtils jwtUtils;

    public DomainUserDetail domainUserDetail(String userName) {
        AccountEntity accountEntity = accountRepository.getAccountByUserName(userName)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        return new DomainUserDetail(
                accountEntity.getAccountId(),
                accountEntity.getUserName(),
                accountEntity.getPassword(),
                Set.of(new SimpleGrantedAuthority(accountEntity.getRole().getRoleName()))
        );
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {

        DomainUserDetail domainUserDetail = domainUserDetail(authenticationRequest.getUserName());
        if (!passwordEncoder.matches(authenticationRequest.getPassword(), domainUserDetail.getPassword())) {
            throw new AppException(ErrorCode.AUTHENTICATION_FAILED);
        }

        String token = jwtUtils.generateToken(domainUserDetail);
        return AuthenticationResponse.builder()
                .token(token)
                .authenticated(true)
                .build();
    }

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
}
