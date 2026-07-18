package com.harpreet.aihelpdesk.response;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

public final class ResponseBuilder {

    private ResponseBuilder() {
    }

    /**
     * Success Response
     */
    public static <T> ApiResponse<T> success(
            String message,
            T data
    ) {

        return ApiResponse.<T>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message(message)
                .data(data)
                .build();

    }

    /**
     * Created Response
     */
    public static <T> ApiResponse<T> created(
            String message,
            T data
    ) {

        return ApiResponse.<T>builder()
                .success(true)
                .status(HttpStatus.CREATED.value())
                .message(message)
                .data(data)
                .build();

    }

    /**
     * Updated Response
     */
    public static <T> ApiResponse<T> updated(
            String message,
            T data
    ) {

        return ApiResponse.<T>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message(message)
                .data(data)
                .build();

    }

    /**
     * Deleted Response
     */
    public static ApiResponse<Void> deleted(
            String message
    ) {

        return ApiResponse.<Void>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message(message)
                .build();

    }

    /**
     * Pagination Response
     */
    public static <T> PagedResponse<T> page(
            Page<T> page,
            String message
    ) {

        return PagedResponse.<T>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message(message)
                .data(page.getContent())
                .pageNumber(page.getNumber())
                .pageSize(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .last(page.isLast())
                .build();

    }

}
