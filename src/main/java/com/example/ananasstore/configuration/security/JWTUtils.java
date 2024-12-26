package com.example.ananasstore.configuration.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
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
    }

    public String generateToken(DomainUserDetail domainUserDetail) {

        return Jwts.builder()
                .subject(domainUserDetail.getUsername())
                .issuer("ananasstore.vn")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();

        //Devteria
//        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
//        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
//                .subject(userName)
//                .issuer("annanas.vn")
//                .issueTime(new Date())
//                .expirationTime(new Date(
//                        Instant.now().plus(EXPIRATION_TIME, ChronoUnit.SECONDS).toEpochMilli()
//                ))
//                .claim("Custom", "hoangnv")
//                .build();
//
//        //create payload
//        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
//        JWSObject jwsObject = new JWSObject(header, payload);
//        try {
//            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
//            return jwsObject.serialize();
//        } catch (JOSEException exception) {
//            throw new RuntimeException("Cannot create JWT object", exception);
//        }
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
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return userName.equals(userDetails.getUsername());
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
