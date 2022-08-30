package com.company.springmvcweb.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data

@Entity
@DiscriminatorValue(value=Category.CatValues.MSPOTLIGHT)
@NoArgsConstructor

public class MSpotlight extends Item{
//@Column(name="power")
    private int power;

    public MSpotlight(int power) {
        this.power = power;
    }

    public MSpotlight(int id, String name, Integer price, String pic, boolean isActive, Location location, int totalCount, int power) {
        super(id, name, price, pic, isActive, location, totalCount);
        this.power = power;
    }

    public MSpotlight(int id, int quantity) {
        super(id, quantity);
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }
}
