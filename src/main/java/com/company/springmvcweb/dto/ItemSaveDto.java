package com.company.springmvcweb.dto;

import com.company.springmvcweb.data.enums.Location;
import lombok.Data;

@Data
public class ItemSaveDto {
    private String category;
    private int id;
    private String name;
    private Float price;
    private String pic;
    private Location location;
    private int totalCount;
    private Float power;
    private Integer length;
    private boolean isActive;

}
