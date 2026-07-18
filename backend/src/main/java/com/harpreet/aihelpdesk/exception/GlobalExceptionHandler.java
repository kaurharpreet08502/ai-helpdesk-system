package com.harpreet.aihelpdesk.exception;


import com.harpreet.aihelpdesk.response.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(

            ResourceNotFoundException ex

    ) {

        ErrorResponse response = ErrorResponse.builder()

                .success(false)

                .status(HttpStatus.NOT_FOUND.value())

                .message(ex.getMessage())

                .timestamp(LocalDateTime.now())

                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND)

                .body(response);

    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(

            BadRequestException ex

    ) {

        ErrorResponse response = ErrorResponse.builder()

                .success(false)

                .status(HttpStatus.BAD_REQUEST.value())

                .message(ex.getMessage())

                .timestamp(LocalDateTime.now())

                .build();

        return ResponseEntity.badRequest()

                .body(response);

    }
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse> handleDuplicate(

            DuplicateResourceException ex

    ) {

        ErrorResponse response = ErrorResponse.builder()

                .success(false)

                .status(HttpStatus.CONFLICT.value())

                .message(ex.getMessage())

                .timestamp(LocalDateTime.now())

                .build();

        return ResponseEntity.status(HttpStatus.CONFLICT)

                .body(response);

    }
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorized(

            UnauthorizedException ex

    ) {

        ErrorResponse response = ErrorResponse.builder()

                .success(false)

                .status(HttpStatus.UNAUTHORIZED.value())

                .message(ex.getMessage())

                .timestamp(LocalDateTime.now())

                .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)

                .body(response);

    }
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ErrorResponse> handleForbidden(

            ForbiddenException ex

    ) {

        ErrorResponse response = ErrorResponse.builder()

                .success(false)

                .status(HttpStatus.FORBIDDEN.value())

                .message(ex.getMessage())

                .timestamp(LocalDateTime.now())

                .build();

        return ResponseEntity.status(HttpStatus.FORBIDDEN)

                .body(response);

    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusiness(

            BusinessException ex

    ) {

        ErrorResponse response = ErrorResponse.builder()

                .success(false)

                .status(HttpStatus.BAD_REQUEST.value())

                .message(ex.getMessage())

                .timestamp(LocalDateTime.now())

                .build();

        return ResponseEntity.badRequest()

                .body(response);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(

            MethodArgumentNotValidException ex

    ) {

        List<String> errors = ex.getBindingResult()

                .getFieldErrors()

                .stream()

                .map(FieldError::getDefaultMessage)

                .toList();

        ErrorResponse response = ErrorResponse.builder()

                .success(false)

                .status(HttpStatus.BAD_REQUEST.value())

                .message("Validation failed.")

                .errors(errors)

                .timestamp(LocalDateTime.now())

                .build();

        return ResponseEntity.badRequest()

                .body(response);

    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraint(

            ConstraintViolationException ex

    ) {

        List<String> errors = ex.getConstraintViolations()

                .stream()

                .map(v -> v.getMessage())

                .toList();

        ErrorResponse response = ErrorResponse.builder()

                .success(false)

                .status(HttpStatus.BAD_REQUEST.value())

                .message("Validation failed.")

                .errors(errors)

                .timestamp(LocalDateTime.now())

                .build();

        return ResponseEntity.badRequest()

                .body(response);

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(

            Exception ex

    ) {

        ErrorResponse response = ErrorResponse.builder()

                .success(false)

                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())

                .message("Something went wrong.")

                .errors(List.of(ex.getMessage()))

                .timestamp(LocalDateTime.now())

                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)

                .body(response);

    }

}