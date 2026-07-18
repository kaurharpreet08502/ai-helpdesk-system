package com.harpreet.aihelpdesk.security.jwt;

import com.harpreet.aihelpdesk.entity.User;
import com.harpreet.aihelpdesk.security.userDetails.CustomUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    private final JwtProperties properties;
    private SecretKey getSigningKey() {

        byte[] keyBytes = Decoders.BASE64.decode(
                properties.getSecret()
        );

        return Keys.hmacShaKeyFor(keyBytes);
    }
         private String buildToken(
                Map<String, Object> claims,
                UserDetails userDetails,
        long expiration){

            Instant now = Instant.now();

            return Jwts.builder()

                    .claims(claims)

                    .subject(userDetails.getUsername())

                    .issuer(properties.getIssuer())

                    .issuedAt(Date.from(now))

                    .expiration(
                            Date.from(
                                    now.plusMillis(expiration)
                            )
                    )

                    .signWith(getSigningKey())

                    .compact();

        }
    @Override
    public String generateAccessToken(UserDetails user) {

        CustomUserDetails customUser = (CustomUserDetails) user;

        User domainUser = customUser.getUser();

        Map<String, Object> claims = new HashMap<>();

        claims.put("userId", domainUser.getId());

        claims.put("role", domainUser.getRole().name());

        if (domainUser.getDepartment() != null) {

            claims.put(
                    "departmentId",
                    domainUser.getDepartment().getId()
            );

        }

        return buildToken(

                claims,

                user,

                properties.getAccessTokenExpiration()

        );

    }
    @Override
    public String generateRefreshToken(
            UserDetails user
    ) {

        return buildToken(

                Map.of(),

                user,

                properties.getRefreshTokenExpiration()

        );

    }
    private Claims extractAllClaims(
            String token
    ) {

        return Jwts.parser()

                .verifyWith(getSigningKey())

                .build()

                .parseSignedClaims(token)

                .getPayload();

    }
    private <T> T extractClaim(

            String token,

            Function<Claims, T> resolver

    ) {

        Claims claims = extractAllClaims(token);

        return resolver.apply(claims);

    }
    @Override
    public String extractUsername(
            String token
    ) {

        return extractClaim(
                token,
                Claims::getSubject
        );

    }
    private Date extractExpiration(
            String token
    ) {

        return extractClaim(
                token,
                Claims::getExpiration
        );

    }
    @Override
    public boolean isTokenExpired(
            String token
    ) {

        return extractExpiration(token)

                .before(new Date());

    }
    @Override
    public boolean validateToken(
            String token,
            UserDetails user
    ) {

        try {

            String username = extractUsername(token);

            return username.equals(user.getUsername())

                    && !isTokenExpired(token);

        }

        catch (JwtException ex) {

            return false;

        }

        catch (Exception ex) {

            return false;

        }

    }
    public String extractIssuer(
            String token
    ) {

        return extractClaim(
                token,
                Claims::getIssuer
        );

    }

    public Date extractIssuedAt(
            String token
    ) {

        return extractClaim(
                token,
                Claims::getIssuedAt
        );

    }
    public Claims getClaims(
            String token
    ) {

        return extractAllClaims(token);

    }
    public Date extractExpiry(
            String token
    ) {

        return extractClaim(
                token,
                Claims::getExpiration
        );

    }
    @Override
    public Long extractUserId(String token) {
        return extractClaim(token, claims -> claims.get("userId", Long.class));
    }

    @Override
    public String extractRole(String token) {
        return extractClaim(token, claims -> claims.get("role", String.class));
    }

    @Override
    public Long extractDepartmentId(String token) {
        return extractClaim(token, claims -> claims.get("departmentId", Long.class));
    }

}