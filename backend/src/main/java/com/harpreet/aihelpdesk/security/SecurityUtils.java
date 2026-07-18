package com.harpreet.aihelpdesk.security;

import com.harpreet.aihelpdesk.entity.User;
import com.harpreet.aihelpdesk.security.userDetails.CustomUserDetails;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityUtils {

    private SecurityUtils() {
    }

    public static User getCurrentUser() {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        if (authentication == null) {
            return null;
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof CustomUserDetails userDetails) {
            return userDetails.getUser();
        }

        return null;

    }

    public static Long getCurrentUserId() {

        User user = getCurrentUser();

        return user != null ? user.getId() : null;

    }

    public static String getCurrentUserEmail() {

        User user = getCurrentUser();

        return user != null ? user.getEmail() : null;

    }

}