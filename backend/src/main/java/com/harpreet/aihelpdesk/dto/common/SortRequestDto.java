package com.harpreet.aihelpdesk.dto.common;

import lombok.Data;

@Data
public class SortRequestDto {

    private String sortBy = "id";

    private String direction = "asc";

}
