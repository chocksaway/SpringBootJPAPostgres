package com.chocksaway.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * Author milesd on 22/03/2019.
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;


    @Column(name="dob")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dob;


    @Column(name = "review")
    private Date review;

    protected Customer() {
    }

    public Customer(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName='%s', dob='%s']", id, firstName, lastName, dob);
    }
}
