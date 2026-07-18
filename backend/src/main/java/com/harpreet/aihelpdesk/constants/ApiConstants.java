package com.harpreet.aihelpdesk.constants;

public final class ApiConstants {

    private ApiConstants() {
    }

    /**
     * API Version
     */
    public static final String API_VERSION = "/api/v1";

    /**
     * Authentication
     */
    public static final String AUTH = API_VERSION + "/auth";

    /**
     * User
     */
    public static final String USERS = API_VERSION + "/users";

    /**
     * Department
     */
    public static final String DEPARTMENTS = API_VERSION + "/departments";

    /**
     * Ticket
     */
    public static final String TICKETS = API_VERSION + "/tickets";

    /**
     * Ticket Comments
     */
    public static final String COMMENTS = API_VERSION + "/comments";

    /**
     * Ticket Attachments
     */
    public static final String ATTACHMENTS = API_VERSION + "/attachments";

    /**
     * Notifications
     */
    public static final String NOTIFICATIONS = API_VERSION + "/notifications";

    /**
     * Reports
     */
    public static final String REPORTS = API_VERSION + "/reports";

    /**
     * AI Chat
     */
    public static final String AI = API_VERSION + "/ai";

    /**
     * Knowledge Base
     */
    public static final String KNOWLEDGE_BASE = API_VERSION + "/knowledge-base";

}