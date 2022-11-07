package com.company.springmvcweb.dto;

import lombok.Data;

@Data
public class InvoiceLineSaveDto {
    private long projectId;
    private String description;
    private float price;
    private int quantity;
    private long baseInvoiceId;
    private String deliveryAddress;



}
