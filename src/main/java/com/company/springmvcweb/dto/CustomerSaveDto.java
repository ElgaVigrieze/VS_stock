package com.company.springmvcweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveDto {
    private String name;
    private String vatNumber;
    private String billingAddress;
//    private String deliveryAddress;
    private String bank;
    private String swift;
    private String accountNumber;
    private String eMail;
    private String phoneNumber;
}
