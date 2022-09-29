package com.company.springmvcweb.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data

@Entity
@DiscriminatorValue(value=Category.CatValues.NMSPOTLIGHT)
@NoArgsConstructor

public class NMSpotlight extends Item{
//@Column(name="power")
    private Float power;

    public NMSpotlight(Float power) {
        this.power = power;
    }

    public NMSpotlight(int id, String name, Float price, String pic, boolean isActive, Location location, int totalCount, Float power) {
        super(id, name, price, pic, isActive, location, totalCount);
        this.power = power;
    }

    public NMSpotlight(int id, int quantity) {
        super(id, quantity);
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }
}
