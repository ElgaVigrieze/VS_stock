package com.company.springmvcweb.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name="Customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="billing_address")
    private String billingAddress;
    @Column(name="delivery_address")
    private String deliveryAddress;
    @Column(name="vat_number")
    private String vatNumber;
    @Column(name="bank")
    private String bank;
    @Column(name="account_number")
    private String accountNumber;
    @Column(name="e_mail")
    private String eMail;



}