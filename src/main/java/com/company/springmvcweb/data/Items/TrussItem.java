package com.company.springmvcweb.data.Items;

import com.company.springmvcweb.data.enums.Category;
import com.company.springmvcweb.data.enums.Location;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue(value= Category.CatValues.TRUSS)
public class TrussItem extends Item {
//    @Column(name="length")
    private Integer length;

    public TrussItem(long id, String name, Float price, String pic, boolean isActive, Location location, int totalCount, Integer length) {
        super(id, name, price, pic, isActive, location, totalCount);
        this.length = length;
    }

    public TrussItem(long id, int quantity) {
        super(id, quantity);
    }

    public TrussItem() {
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }
}

