package com.harpreet.aihelpdesk.service.auth;

import com.harpreet.aihelpdesk.dto.auth.CurrentUserResponse;
import com.harpreet.aihelpdesk.dto.auth.LoginRequest;
import com.harpreet.aihelpdesk.dto.auth.LoginResponse;
import com.harpreet.aihelpdesk.dto.auth.RefreshTokenRequest;
import com.harpreet.aihelpdesk.dto.auth.RefreshTokenResponse;

public interface AuthenticationService {

    /**
     * Authenticates a user and generates
     * access token + refresh token.
     *
     * @param request Login credentials
     * @return LoginResponse
     */
    LoginResponse login(LoginRequest request);

    /**
     * Generates a new access token using
     * a valid refresh token.
     *
     * @param request Refresh token request
     * @return RefreshTokenResponse
     */
    RefreshTokenResponse refreshToken(
            RefreshTokenRequest request
    );

    /**
     * Logs out the current user by revoking
     * the supplied refresh token.
     *
     * @param refreshToken Refresh token
     */
    void logout(String refreshToken);

    /**
     * Returns the currently authenticated user.
     *
     * @return CurrentUserResponse
     */
    CurrentUserResponse getCurrentUser();

}
