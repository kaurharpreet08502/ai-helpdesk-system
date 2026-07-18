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
public class PagedResponse<T> {

    private boolean success;

    private String message;

    private int status;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

    private List<T> data;

    private int pageNumber;

    private int pageSize;

    private long totalElements;

    private int totalPages;

    private boolean last;

}