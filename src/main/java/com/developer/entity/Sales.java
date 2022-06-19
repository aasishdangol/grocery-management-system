package com.developer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

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

        @Column(name = "status")
        private String status;
}