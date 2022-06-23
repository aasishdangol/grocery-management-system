package com.developer.dao;

import com.developer.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SalesDetailsDao {

    private Long salesId;
    private String salesCode;
    private String date;
    private String paymentBy;
    private String discount;
    private List<ProductDto> product;
}
