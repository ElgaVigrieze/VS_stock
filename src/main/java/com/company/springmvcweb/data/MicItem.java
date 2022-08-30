package com.company.springmvcweb.data;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@DiscriminatorValue(value=Category.CatValues.MIC)


public class MicItem extends Item{

    public MicItem(int id, String name, Integer price, String pic, boolean isActive, Location location, int totalCount) {
        super(id, name, price, pic, isActive, location, totalCount);
    }

    public MicItem(int id, String name, Integer price, boolean isActive, Location location, int totalCount) {
        super(id, name, price, isActive, location, totalCount);
    }

    public MicItem(int id, int quantity) {
        super(id,  quantity);
    }

    public MicItem() {
        super();
    }

@Override
public String getCategory() {
    return super.getCategory();
}
}

