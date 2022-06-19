package com.example.demo.entity;

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

    @Column(name="category_id")
    private String categoryId;

    @Column(name = "category_name")
    public String  name;

    @Column(name = "category_desc")
    public String  description;

    @Column(name = "status")
    public String  status;

    @Column(name="create_date")
    public String createDate;

}
