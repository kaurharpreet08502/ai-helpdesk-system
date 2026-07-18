package com.harpreet.aihelpdesk.service.auth;

import com.harpreet.aihelpdesk.dto.auth.CurrentUserResponse;
import com.harpreet.aihelpdesk.dto.auth.LoginRequest;
import com.harpreet.aihelpdesk.dto.auth.LoginResponse;
import com.harpreet.aihelpdesk.dto.auth.RefreshTokenRequest;
import com.harpreet.aihelpdesk.dto.auth.RefreshTokenResponse;
import com.harpreet.aihelpdesk.service.auth.AuthenticationService;
import com.harpreet.aihelpdesk.entity.RefreshToken;
import com.harpreet.aihelpdesk.entity.User;
import com.harpreet.aihelpdesk.repository.RefreshTokenRepository;
import com.harpreet.aihelpdesk.repository.UserRepository;
import com.harpreet.aihelpdesk.security.jwt.JwtProperties;
import com.harpreet.aihelpdesk.security.jwt.JwtService;
import com.harpreet.aihelpdesk.security.userDetails.CustomUserDetails;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final JwtProperties jwtProperties;

    private final UserRepository userRepository;

    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public LoginResponse login(LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(

                        new UsernamePasswordAuthenticationToken(

                                request.getEmail(),

                                request.getPassword()

                        )
                );

        CustomUserDetails userDetails =
                (CustomUserDetails) authentication.getPrincipal();

        User user = userDetails.getUser();

        refreshTokenRepository.deleteByUser(user);

        String accessToken =
                jwtService.generateAccessToken(userDetails);

        String refreshToken =
                jwtService.generateRefreshToken(userDetails);

        RefreshToken refreshTokenEntity =
                createRefreshToken(user, refreshToken);

        refreshTokenRepository.save(refreshTokenEntity);

        return LoginResponse.builder()

                .accessToken(accessToken)

                .refreshToken(refreshToken)

                .tokenType("Bearer")

                .expiresIn(jwtProperties.getAccessTokenExpiration())

                .userId(user.getId())

                .firstName(user.getFirstName())

                .lastName(user.getLastName())

                .email(user.getEmail())

                .role(user.getRole())

                .departmentId(
                        user.getDepartment() != null
                                ? user.getDepartment().getId()
                                : null
                )

                .build();

    }

    private RefreshToken createRefreshToken(
            User user,
            String token
    ) {

        return RefreshToken.builder()

                .user(user)

                .token(token)

                .expiryDate(

                        LocalDateTime.now()

                                .plus(Duration.ofMillis(
                                        jwtProperties.getRefreshTokenExpiration()
                                )))

                .expired(false)

                .revoked(false)

                .build();

    }
    @Override
    public RefreshTokenResponse refreshToken(
            RefreshTokenRequest request
    ) {

        RefreshToken refreshToken = refreshTokenRepository

                .findByToken(request.getRefreshToken())

                .orElseThrow(() ->
                        new RuntimeException("Invalid refresh token.")
                );

        if (Boolean.TRUE.equals(refreshToken.getRevoked())
                || Boolean.TRUE.equals(refreshToken.getExpired())) {

            throw new RuntimeException(
                    "Refresh token has been revoked."
            );

        }

        if (refreshToken.getExpiryDate().isBefore(LocalDateTime.now())) {

            refreshToken.setExpired(true);

            refreshTokenRepository.save(refreshToken);

            throw new RuntimeException(
                    "Refresh token has expired."
            );

        }

        User user = refreshToken.getUser();

        CustomUserDetails userDetails =
                new CustomUserDetails(user);

        String newAccessToken =
                jwtService.generateAccessToken(userDetails);

        String newRefreshToken =
                jwtService.generateRefreshToken(userDetails);

        refreshToken.setToken(newRefreshToken);

        refreshToken.setExpiryDate(


                LocalDateTime.now()
                        .plus(Duration.ofMillis(
                                jwtProperties.getRefreshTokenExpiration()
                        ))

        );

        refreshTokenRepository.save(refreshToken);

        return RefreshTokenResponse.builder()

                .accessToken(newAccessToken)

                .refreshToken(newRefreshToken)

                .tokenType("Bearer")

                .expiresIn(
                        jwtProperties.getAccessTokenExpiration()
                )

                .build();

    }

    @Override
    public void logout(String refreshToken) {

        RefreshToken token = refreshTokenRepository

                .findByToken(refreshToken)

                .orElseThrow(() ->
                        new RuntimeException("Refresh token not found.")
                );

        token.setRevoked(true);

        token.setExpired(true);

        refreshTokenRepository.save(token);

    }

    @Override
    @Transactional(readOnly = true)
    public CurrentUserResponse getCurrentUser() {

        User user = getCurrentAuthenticatedUser();

        return CurrentUserResponse.builder()

                .id(user.getId())

                .employeeId(user.getEmployeeId())

                .firstName(user.getFirstName())

                .lastName(user.getLastName())

                .fullName(user.getFirstName() + " " + user.getLastName())

                .email(user.getEmail())

                .phoneNumber(user.getPhoneNumber())

                .role(user.getRole())

                .status(user.getStatus())

                .departmentId(
                        user.getDepartment() != null
                                ? user.getDepartment().getId()
                                : null
                )

                .departmentName(
                        user.getDepartment() != null
                                ? user.getDepartment().getDepartmentName()
                                : null
                )

                .designation(user.getDesignation().name())

                .enabled(user.getEnabled())

                .locked(user.getLocked())

                .build();

    }

    private User getCurrentAuthenticatedUser() {

        Authentication authentication =
                SecurityContextHolder

                        .getContext()

                        .getAuthentication();

        if (authentication == null
                || !(authentication.getPrincipal()
                instanceof CustomUserDetails customUserDetails)) {

            throw new RuntimeException(
                    "No authenticated user found."
            );

        }

        Long userId = customUserDetails

                .getUser()

                .getId();

        return userRepository

                .findById(userId)

                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "Authenticated user not found."
                        )
                );

    }

}
