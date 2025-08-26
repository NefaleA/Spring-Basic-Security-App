package com.security_app.security_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "users")
@Setter
@Getter
public class User {
    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "first-name", nullable = false)
    private String firstname;

    @Column(name = "middle-name", nullable = true)
    private String middlename;

    @Column(name = "last-name", nullable = false)
    private String lastname;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;
}
