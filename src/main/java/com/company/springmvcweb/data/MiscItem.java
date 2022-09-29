package com.company.springmvcweb.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@DiscriminatorValue(value=Category.CatValues.MISC)

public class MiscItem extends Item{

    public MiscItem(int id, String name, Float price, String pic, boolean isActive, Location location, int totalCount) {
        super(id, name, price, pic, isActive, location, totalCount);
    }

    public MiscItem() {
    }

    public MiscItem(int id,  int quantity) {
        super(id, quantity);
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }
}

