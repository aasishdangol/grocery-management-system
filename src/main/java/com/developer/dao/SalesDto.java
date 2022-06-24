package com.developer.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesDto {

    private Long id;
    private String salesCode;
    private String date;
    private String paymentBy;
    private String discount;

}
