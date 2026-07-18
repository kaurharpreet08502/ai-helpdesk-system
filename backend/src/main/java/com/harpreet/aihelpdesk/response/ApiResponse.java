package com.harpreet.aihelpdesk.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    /**
     * Indicates API Success/Failure
     */
    private boolean success;

    /**
     * Response Message
     */
    private String message;

    /**
     * HTTP Status Code
     */
    private int status;

    /**
     * Response Time
     */
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

    /**
     * Response Payload
     */
    private T data;

    public static <T> ApiResponse<T> success(
            String message,
            T data
    ) {

        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build();

    }
    public static <T> ApiResponse<T> failure(
            String message
    ) {

        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .build();

    }

}