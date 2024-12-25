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
    private static final String ALGORITHM = "HmacSHA512";
    private static final long EXPIRATION_TIME = 86400000L; //24 hours

    @PostConstruct
    protected void init() {
        this.keyByte = Base64.getDecoder().decode(SIGNER_KEY.getBytes(StandardCharsets.UTF_8));
    }
    public String generateToken(UserDetails userDetails) {

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuer("ananasstore.vn")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, keyByte)
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
    public String generateRefreshToken(HashMap<String, Object> claims, UserDetails userDetails) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuer("ananasstore.vn")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, keyByte)
                .compact();
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        return claimsResolver.apply(Jwts.parser().veryi)
    }
}
