package com.company.springmvcweb.data;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue(value=Category.CatValues.TRANSPORT)
public class TransportItem extends Item{

    public TransportItem(int id, String name, Integer price, String pic, boolean isActive, Location location, int totalCount) {
        super(id, name, price, pic, isActive, location, totalCount);
    }

    public TransportItem(int id, int quantity) {
        super(id, quantity);
    }

    public TransportItem() {
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }
}

