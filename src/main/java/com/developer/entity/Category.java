package com.developer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Category implements Serializable {
    private static final long serialversionUID = 20220906001637L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String  name;

    @Column(name = "category_desc")
    private String  description;

    @Column(name = "status")
    private String  status;

    @Column(name="create_date")
    private String createDate;

}
