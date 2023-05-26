package com.shopitems.shopitemsmanagement.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ItemResponseDto {

    private long id;
    private BigDecimal price;
    private String name;

}
