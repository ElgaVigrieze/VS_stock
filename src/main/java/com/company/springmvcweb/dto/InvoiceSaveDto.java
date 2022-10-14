package com.company.springmvcweb.dto;

import lombok.Data;

@Data
public class InvoiceSaveDto {
    private String type;
    private long customerId;
    private String description;
    private Long projectId;
    private String comment;
    private float sum;

}
