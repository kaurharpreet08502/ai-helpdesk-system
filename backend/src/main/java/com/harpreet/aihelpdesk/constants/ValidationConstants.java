package com.harpreet.aihelpdesk.constants;

public final class ValidationConstants {

    private ValidationConstants() {
    }

    /*
     * User
     */
    public static final int NAME_MIN_LENGTH = 2;

    public static final int NAME_MAX_LENGTH = 50;

    public static final int PASSWORD_MIN_LENGTH = 8;

    public static final int PASSWORD_MAX_LENGTH = 100;

    public static final int PHONE_LENGTH = 10;

    /*
     * Ticket
     */
    public static final int TITLE_MIN_LENGTH = 5;

    public static final int TITLE_MAX_LENGTH = 150;

    public static final int DESCRIPTION_MIN_LENGTH = 10;

    public static final int DESCRIPTION_MAX_LENGTH = 5000;

    /*
     * Department
     */
    public static final int DEPARTMENT_NAME_MAX_LENGTH = 100;

    /*
     * Knowledge Base
     */
    public static final int DOCUMENT_NAME_MAX_LENGTH = 255;

}