package com.company.springmvcweb.data;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue(value=Category.CatValues.STAND)
public class StandItem extends Item{

    public StandItem(int id, String name, Integer price, String pic, boolean isActive, Location location, int totalCount) {
        super(id, name, price, pic, isActive, location, totalCount);
    }

    public StandItem(int id, int quantity) {
        super(id, quantity);
    }

    public StandItem() {
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }
}

