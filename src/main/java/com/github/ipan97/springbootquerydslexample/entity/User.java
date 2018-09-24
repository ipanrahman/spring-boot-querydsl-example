package com.github.ipan97.springbootquerydslexample.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Ipan Taupik Rahman
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "first_name", length = 30)
    private String firstName;

    @Column(name = "last_name", length = 40)
    private String lastName;

    @Column(name = "email", length = 30, unique = true)
    private String email;

    @Column(name = "age")
    private Integer age;
}
