package com.company.springmvcweb.data;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue(value=Category.CatValues.WORK)
public class WorkItem extends Item{

    public WorkItem(int id, String name, Integer price, String pic, boolean isActive, Location location, int totalCount) {
        super(id, name, price, pic, isActive, location, totalCount);
    }

    public WorkItem(int id, int quantity) {
        super(id, quantity);
    }

    public WorkItem() {
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }
}

