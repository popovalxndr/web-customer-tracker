package com.popovalxndr.springhibernatedemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="customer")
@NoArgsConstructor
@ToString
public class Customer {

    @Id
    @GeneratedValue
    @Column
    @Getter @Setter
    private int id;

    @Column(name="first_name")
    @Getter @Setter
    private String firstName;

    @Column(name="last_name")
    @Getter @Setter
    private String lastName;

    @Column(name="email")
    @Getter @Setter
    private String email;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
