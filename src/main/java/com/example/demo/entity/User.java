package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCloudPlatform;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID =20220806001603L;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id")
private Long id;

@Column(name = "user_id")
private String userId;

@Column(name="first_name")
private  String firstName;

@Column(name="last_name")
private  String lastName;

@Column(name="address")
private  String address;

@Column(name = "gender")
private String gender;

@Column(name="email")
private  String email;

@Column(name="status")
private  String status = "active";

@Column(name = "password")
private String password;

    @ManyToOne
    @JoinColumn(name="usertype_id")
    private UserType userType;

    public User() {
        super();
    }
}

