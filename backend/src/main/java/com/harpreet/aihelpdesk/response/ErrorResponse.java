package com.harpreet.aihelpdesk.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    /**
     * Always false
     */
    private boolean success;

    /**
     * Error Message
     */
    private String message;

    /**
     * HTTP Status
     */
    private int status;

    /**
     * Validation Errors
     */
    private List<String> errors;

    /**
     * API Time
     */
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

}
