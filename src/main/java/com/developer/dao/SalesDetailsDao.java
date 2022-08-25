package com.developer.dao;

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
    private Integer discount=0;
    private String vat ="15%";
    private List<ProductDto> product;
    private Integer subTotal = 0;
    private Integer grandTotal=0;
}
