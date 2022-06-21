package com.developer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "role",
        uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Role implements Serializable {

    private static final long serialVersionUID = 201801210011543L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Transient
    private Boolean selected;

}
