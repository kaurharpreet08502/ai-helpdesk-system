package com.harpreet.aihelpdesk.controller.auth;

import com.harpreet.aihelpdesk.dto.auth.CurrentUserResponse;
import com.harpreet.aihelpdesk.dto.auth.LoginRequest;
import com.harpreet.aihelpdesk.dto.auth.LoginResponse;
import com.harpreet.aihelpdesk.dto.auth.RefreshTokenRequest;
import com.harpreet.aihelpdesk.dto.auth.RefreshTokenResponse;
import com.harpreet.aihelpdesk.response.ApiResponse;
import com.harpreet.aihelpdesk.service.auth.AuthenticationService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(

            @Valid
            @RequestBody
            LoginRequest request

    ) {

        LoginResponse response =
                authenticationService.login(request);

        return ResponseEntity.ok(

                ApiResponse.success(

                        "Login successful",

                        response

                )

        );

    }

    @PostMapping("/refresh")
    public ResponseEntity<ApiResponse<RefreshTokenResponse>> refreshToken(

            @Valid
            @RequestBody
            RefreshTokenRequest request

    ) {

        RefreshTokenResponse response =
                authenticationService.refreshToken(request);

        return ResponseEntity.ok(

                ApiResponse.success(

                        "Token refreshed successfully",

                        response

                )

        );

    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<Void>> logout(

            @RequestHeader("Refresh-Token")
            String refreshToken

    ) {

        authenticationService.logout(refreshToken);

        return ResponseEntity.ok(

                ApiResponse.success(

                        "Logout successful",

                        null

                )

        );

    }

    @GetMapping("/me")
    public ResponseEntity<ApiResponse<CurrentUserResponse>> currentUser() {

        CurrentUserResponse response =
                authenticationService.getCurrentUser();

        return ResponseEntity.ok(

                ApiResponse.success(

                        "Current user fetched successfully",

                        response

                )

        );

    }

    @GetMapping("/authenticated")
    public ResponseEntity<ApiResponse<Boolean>> authenticated(

            Authentication authentication

    ) {

        return ResponseEntity.ok(

                ApiResponse.success(

                        "Authentication status",

                        authentication != null
                                && authentication.isAuthenticated()

                )

        );

    }

}