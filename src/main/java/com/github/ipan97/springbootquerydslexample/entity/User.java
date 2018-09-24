package com.github.ipan97.springbootquerydslexample.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Ipan Taupik Rahman
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "firstname", length = 30)
    private String firstname;

    @Column(name = "lastname", length = 40)
    private String lastname;

    @Column(name = "email", length = 30, unique = true)
    private String email;

    @Column(name = "age")
    private Integer age;
}
