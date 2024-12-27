package com.example.ananasstore.configuration.security;

import com.example.ananasstore.dto.requests.ValidTokenRequest;
import io.jsonwebtoken.Claims;
import jakarta.annotation.PostConstruct;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Component
public class JWTUtils {
    @NonFinal
    @Value("${jwt.key}")
    protected String SIGNER_KEY;
    byte[] keyByte;
    private static final String ALGORITHM = "HmacSHA256";
    private static final long EXPIRATION_TIME = 86400000L; //24 hours
    private SecretKey key;

    @PostConstruct
    protected void init() {
        this.keyByte = Base64.getDecoder().decode(SIGNER_KEY.getBytes(StandardCharsets.UTF_8));
        key = new SecretKeySpec(keyByte, ALGORITHM);
        System.out.println("Signing Key Length: " + SIGNER_KEY.getBytes().length);
    }

    public String generateToken(DomainUserDetail domainUserDetail) {

        return Jwts.builder()
                .subject(domainUserDetail.getUsername())
                .issuer("ananasstore.vn")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public String generateRefreshToken(HashMap<String, Object> claims, DomainUserDetail domainUserDetail) {

        return Jwts.builder()
                .claims(claims)
                .subject(domainUserDetail.getUsername())
                .issuer("ananasstore.vn")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    //verify token
    public Boolean validateToken(ValidTokenRequest validTokenRequest) {
        Jwts.parser()
                .verifyWith(key)

        return true;
    }

    //get Username from token
    private String extractUserName(String token) {
        return extractClaim(token, new Function<Claims, String>() {
            @Override
            public String apply(Claims claims) {
                return claims.getSubject();
            }
        });
    }

    //Check time token
    private boolean isTokenExpired(String token) {
        return extractClaim(token, new Function<Claims, Boolean>() {
            @Override
            public Boolean apply(Claims claims) {
                return claims.getExpiration().before(new Date());
            }
        });
    }

    private <R> R extractClaim(String token, Function<Claims, R> claimsResolver) {
        Claims claims = Jwts
                .parser()
                .verifyWith(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }
}
