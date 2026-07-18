package com.harpreet.aihelpdesk.dto.common;

import lombok.Data;

@Data
public class PageRequestDto {

    /**
     * Page Number
     */
    private Integer page = 0;

    /**
     * Records Per Page
     */
    private Integer size = 10;

    /**
     * Sort Field
     */
    private String sortBy = "id";

    /**
     * asc / desc
     */
    private String direction = "asc";

}
