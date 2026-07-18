package com.harpreet.aihelpdesk.security.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public interface JwtService {

    String generateAccessToken(UserDetails userDetails);

    String generateRefreshToken(UserDetails userDetails);

    String extractUsername(String token);

    Long extractUserId(String token);

    String extractRole(String token);

    Long extractDepartmentId(String token);

    Date extractIssuedAt(String token);

    Date extractExpiry(String token);

    Claims getClaims(String token);

    boolean validateToken(String token, UserDetails userDetails);

    boolean isTokenExpired(String token);

}