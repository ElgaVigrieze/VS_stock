package com.company.springmvcweb.data.Items;

import com.company.springmvcweb.data.enums.Category;
import com.company.springmvcweb.data.enums.Location;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@DiscriminatorValue(value= Category.CatValues.MISC)

public class MiscItem extends Item {

    public MiscItem(long id, String name, Float price, String pic, boolean isActive, Location location, int totalCount) {
        super(id, name, price, pic, isActive, location, totalCount);
    }

    public MiscItem() {
    }

    public MiscItem(long id,  int quantity) {
        super(id, quantity);
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }
}

