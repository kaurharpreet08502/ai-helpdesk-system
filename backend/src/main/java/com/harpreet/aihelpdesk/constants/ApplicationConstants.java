package com.harpreet.aihelpdesk.constants;

public final class ApplicationConstants {

    private ApplicationConstants() {
    }

    /**
     * Application
     */
    public static final String APPLICATION_NAME = "AI HelpDesk Management System";

    public static final String APPLICATION_VERSION = "1.0.0";

    /**
     * Pagination
     */
    public static final int DEFAULT_PAGE_NUMBER = 0;

    public static final int DEFAULT_PAGE_SIZE = 10;

    public static final String DEFAULT_SORT_BY = "id";

    public static final String DEFAULT_SORT_DIRECTION = "asc";

    /**
     * Date Formats
     */
    public static final String DATE_FORMAT = "dd-MM-yyyy";

    public static final String DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";

    /**
     * Upload
     */
    public static final long MAX_FILE_SIZE = 10 * 1024 * 1024;

    public static final int MAX_UPLOAD_FILES = 5;

    /**
     * AI
     */
    public static final int MAX_CHAT_HISTORY = 20;

}
