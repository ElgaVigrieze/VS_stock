package com.company.springmvcweb.data.Items;

import com.company.springmvcweb.data.enums.Category;
import com.company.springmvcweb.data.enums.Location;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@DiscriminatorValue(value= Category.CatValues.STAGE)
public class StageItem extends Item {

    public StageItem(long id, String name, Float price, String pic, boolean isActive, Location location, int totalCount) {
        super(id, name, price, pic, isActive, location, totalCount);
    }

    public StageItem(long id, int quantity) {
        super(id, quantity);
    }

    public StageItem() {
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }
}

