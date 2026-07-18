package com.harpreet.aihelpdesk.constants;

import java.util.List;

public final class FileConstants {

    private FileConstants() {
    }

    /*
     * Upload Directory
     */
    public static final String UPLOAD_DIRECTORY = "uploads/";

    public static final String PROFILE_DIRECTORY = "profile/";

    public static final String TICKET_DIRECTORY = "tickets/";

    public static final String KNOWLEDGE_DIRECTORY = "knowledge-base/";

    /*
     * Maximum File Size
     */
    public static final long MAX_FILE_SIZE = 10 * 1024 * 1024;

    /*
     * Allowed Extensions
     */
    public static final List<String> IMAGE_TYPES = List.of(
            "jpg",
            "jpeg",
            "png"
    );

    public static final List<String> DOCUMENT_TYPES = List.of(
            "pdf",
            "doc",
            "docx",
            "txt"
    );

}