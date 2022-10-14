package com.company.springmvcweb.data.Items;

import com.company.springmvcweb.data.enums.Category;
import com.company.springmvcweb.data.enums.Location;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue(value= Category.CatValues.STAND)
public class StandItem extends Item {

    public StandItem(long id, String name, Float price, String pic, boolean isActive, Location location, int totalCount) {
        super(id, name, price, pic, isActive, location, totalCount);
    }

    public StandItem(long id, int quantity) {
        super(id, quantity);
    }

    public StandItem() {
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }
}

