package com.developer.entity;

import com.developer.dao.ProductDto;
import com.developer.util.ConstantValue;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "sales")
public class Sales implements Serializable {
        private static final long serialversionUID = 202200619001130L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Long id;

        @Column(name="sales_code")
        private String salesCode;

        @Column(name="date")
        private String date;

        @Column(name="payment_by")
        private String paymentBy;

        @Column(name="discount")
        private String discount;

        @OneToMany(mappedBy = "sales",cascade = CascadeType.ALL)
        private Set<SalesDetails> salesDetails;


        @Transient
        private Boolean selected;

        @Transient
        private List<String> paymentMethod = Arrays.asList(ConstantValue.getPaymentMethods);

        @Transient
        private List<Product> productList = new ArrayList<>();

        @Transient
        private List<ProductDto> productDtoList = new ArrayList<>();


}

