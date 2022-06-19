package com.developer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Product implements Serializable {
  private static final long serialversionUID = 202200615001617L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name="product_code")
  private String productCode;

  @Column(name="name")
  private String name;

  @Column(name="quantity")
  private String quantity;

  @Column(name="price")
  private String price;

  @Column(name = "description")
  private String description;

  @Column(name = "status")
  private String status;

  @ManyToOne
  @JoinColumn(name="category_id")
  private Category category;
}
