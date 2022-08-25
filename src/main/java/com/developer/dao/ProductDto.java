package com.developer.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String productCode;
    private String name;
    private Integer quantity;
    private Integer sellingPrice;
    private Integer amount;

}
