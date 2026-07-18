package com.harpreet.aihelpdesk.dto.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageResponseDto {

    private Integer page;

    private Integer size;

    private Long totalElements;

    private Integer totalPages;

    private Boolean last;

}