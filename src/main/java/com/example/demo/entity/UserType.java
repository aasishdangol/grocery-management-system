package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class UserType implements Serializable {
    private static final long serialVersionUID =20220806001914L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "id")
    private Long id;

    @Column(name = "usertype_id")
    private String usertypeId;

    @Column(name = "name")
    private String name;

    @Column(name="description")
    private String description;
}
