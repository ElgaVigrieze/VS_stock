package com.company.springmvcweb.data;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Data
@Entity
@DiscriminatorValue(value=Category.CatValues.SPEAKER)


public class SpeakerItem extends Item{

    public SpeakerItem(int id, String name, Integer price, String pic, boolean isActive, Location location, int totalCount) {
        super(id, name, price, pic, isActive, location, totalCount);
    }

    public SpeakerItem(int id, int quantity) {
        super(id,  quantity);
    }

    public SpeakerItem() {
        super();
    }

@Override
public String getCategory() {
    return super.getCategory();
}
}

