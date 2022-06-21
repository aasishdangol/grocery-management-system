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


        @Transient
        private Boolean selected;

        public Sales() {
                super();
        }

        public Long getId() {
                return id;
        }
        public void setId(Long id) {
                this.id = id;
        }

        public String getDate() {
                return date;
        }
        public void setDate(String date) {
                this.date = date;
        }

        public String getPaymentBy() {
                return paymentBy;
        }
        public void setPaymentBy(String paymentBy) {
                this.paymentBy = paymentBy;
        }

        public String getDiscount() {
                return discount;
        }
        public void setDiscount(String discount) {
                this.discount = discount;
        }

        public Boolean getSelected() {
                return selected;
        }

        public void setSelected(Boolean selected) {
                this.selected = selected;
        }
}

