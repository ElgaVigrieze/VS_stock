package com.company.springmvcweb.dto;

import com.company.springmvcweb.data.Category;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class ItemSaveDto2 {
    private List<Integer> id;
//    private List<Integer> check;
    private List<Integer> quantity;
    private List<Float> price;
    private List<Integer> done;

}
