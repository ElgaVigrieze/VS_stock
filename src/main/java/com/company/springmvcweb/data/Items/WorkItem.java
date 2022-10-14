package com.company.springmvcweb.data.Items;

import com.company.springmvcweb.data.enums.Category;
import com.company.springmvcweb.data.enums.Location;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue(value= Category.CatValues.WORK)
public class WorkItem extends Item {

    public WorkItem(long id, String name, Float price, String pic, boolean isActive, Location location, int totalCount) {
        super(id, name, price, pic, isActive, location, totalCount);
    }

    public WorkItem(long id, int quantity) {
        super(id, quantity);
    }

    public WorkItem() {
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }
}

