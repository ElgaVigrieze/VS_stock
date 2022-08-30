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
    private int price;
    private String pic;
    private Location location;
    private int totalCount;
    private int power;
    private int length;
    private boolean isActive;


//    public Category getCategory() {
//        return Category.valueOfLabel(category);
//    }
}
