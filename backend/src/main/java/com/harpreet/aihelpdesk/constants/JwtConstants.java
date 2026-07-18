package com.harpreet.aihelpdesk.constants;

public final class JwtConstants {

    private JwtConstants() {
    }

    /*
     * JWT Claims
     */
    public static final String CLAIM_USER_ID = "userId";

    public static final String CLAIM_EMAIL = "email";

    public static final String CLAIM_ROLE = "role";

    public static final String CLAIM_DEPARTMENT = "department";

    public static final String CLAIM_EMPLOYEE_ID = "employeeId";

    /*
     * Token Prefix
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /*
     * Header
     */
    public static final String HEADER = "Authorization";

    /*
     * Token Type
     */
    public static final String ACCESS_TOKEN = "ACCESS";

    public static final String REFRESH_TOKEN = "REFRESH";

}