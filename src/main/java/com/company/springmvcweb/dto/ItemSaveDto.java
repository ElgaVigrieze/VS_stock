package com.company.springmvcweb.dto;

import com.company.springmvcweb.data.Category;
import com.company.springmvcweb.data.Location;
import lombok.Data;

import java.util.List;

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
