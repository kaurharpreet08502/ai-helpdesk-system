package com.harpreet.aihelpdesk.constants;

public final class SecurityConstants {

    private SecurityConstants() {
    }

    /*
     * Authentication Header
     */
    public static final String AUTHORIZATION = "Authorization";

    public static final String BEARER = "Bearer ";

    /*
     * Security Endpoints
     */
    public static final String AUTH_BASE_URL = "/api/v1/auth/**";

    public static final String SWAGGER_UI = "/swagger-ui/**";

    public static final String API_DOCS = "/v3/api-docs/**";

    public static final String H2_CONSOLE = "/h2-console/**";
    public static final String AUTHORIZATION_HEADER = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final int TOKEN_PREFIX_LENGTH = 7;

    /*
     * Roles
     */
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    public static final String ROLE_SUPPORT_MANAGER = "ROLE_SUPPORT_MANAGER";

    public static final String ROLE_SUPPORT_ENGINEER = "ROLE_SUPPORT_ENGINEER";

    public static final String ROLE_EMPLOYEE = "ROLE_EMPLOYEE";

    /*
     * Password Encoding
     */
    public static final int BCRYPT_STRENGTH = 12;

}
