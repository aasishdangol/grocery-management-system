package com.developer.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String productCode;
    private String name;
    private int quantity;
    private String sellingPrice;
    private String amount;

}
