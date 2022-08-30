package com.company.springmvcweb.data;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue(value=Category.CatValues.VIDEO)
public class VideoItem extends Item{

    public VideoItem(int id, String name, Integer price, String pic, boolean isActive, Location location, int totalCount) {
        super(id, name, price, pic, isActive, location, totalCount);
    }

    public VideoItem(int id, int quantity) {
        super(id, quantity);
    }

    public VideoItem() {
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }
}

