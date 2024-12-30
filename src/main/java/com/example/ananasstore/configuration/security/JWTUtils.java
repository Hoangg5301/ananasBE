package com.example.ananasstore.configuration.security;

import ch.qos.logback.core.util.StringUtil;
import com.example.ananasstore.dto.requests.ValidTokenRequest;
import com.example.ananasstore.exception.AppException;
import com.example.ananasstore.exception.ErrorCode;
import io.jsonwebtoken.*;
import jakarta.annotation.PostConstruct;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.*;
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
                .claim("String", buildScope(domainUserDetail))
                .subject(domainUserDetail.getUsername())
                .issuer("ananasstore.vn")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    //verify token
    public Boolean validateToken(ValidTokenRequest validTokenRequest) {
        try{
            Jwts.parser().verifyWith(key).build().parseSignedClaims(validTokenRequest.getToken());
        } catch(SecurityException | MalformedJwtException e) {
            throw new AppException(ErrorCode.JWT_INCORRECT);
        } catch (ExpiredJwtException e) {
            throw new AppException(ErrorCode.JWT_EXPIRED);
        } catch (UnsupportedJwtException e) {
            throw new AppException(ErrorCode.UNSUPPORTED_JWT_TOKEN);
        } catch (IllegalArgumentException e) {
            throw new AppException(ErrorCode.JWT_INVALID);
        }
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

    private String buildScope(DomainUserDetail domainUserDetail) {
        StringJoiner scope = new StringJoiner(" ");
        if(!CollectionUtils.isEmpty(domainUserDetail.getAuthorities())) {
            for (GrantedAuthority authority : domainUserDetail.getAuthorities()) {
                scope.add(authority.getAuthority());
            }
        }
        return scope.toString();
    }
}
