package com.harpreet.aihelpdesk.constants;

public final class MessageConstants {

    private MessageConstants() {
    }

    /**
     * Common
     */
    public static final String SUCCESS = "Operation completed successfully.";

    public static final String FAILED = "Operation failed.";

    public static final String CREATED = "Record created successfully.";

    public static final String UPDATED = "Record updated successfully.";

    public static final String DELETED = "Record deleted successfully.";

    /**
     * Authentication
     */
    public static final String LOGIN_SUCCESS = "Login successful.";

    public static final String LOGOUT_SUCCESS = "Logout successful.";

    public static final String INVALID_CREDENTIALS = "Invalid username or password.";

    public static final String SESSION_EXPIRED = "Session expired. Please login again.";

    public static final String ACCESS_DENIED = "Access denied.";

    /**
     * User
     */
    public static final String USER_CREATED = "User created successfully.";

    public static final String USER_UPDATED = "User updated successfully.";

    public static final String USER_DELETED = "User deleted successfully.";

    public static final String USER_NOT_FOUND = "User not found.";

    /**
     * Department
     */
    public static final String DEPARTMENT_CREATED = "Department created successfully.";

    public static final String DEPARTMENT_UPDATED = "Department updated successfully.";

    public static final String DEPARTMENT_DELETED = "Department deleted successfully.";

    /**
     * Ticket
     */
    public static final String TICKET_CREATED = "Ticket created successfully.";

    public static final String TICKET_UPDATED = "Ticket updated successfully.";

    public static final String TICKET_ASSIGNED = "Ticket assigned successfully.";

    public static final String TICKET_CLOSED = "Ticket closed successfully.";

    /**
     * Knowledge Base
     */
    public static final String DOCUMENT_UPLOADED = "Document uploaded successfully.";

    /**
     * AI
     */
    public static final String AI_RESPONSE_GENERATED = "AI response generated successfully.";

}