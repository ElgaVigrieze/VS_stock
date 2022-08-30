package com.company.springmvcweb.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@DiscriminatorValue(value=Category.CatValues.STAGE)
public class StageItem extends Item{

    public StageItem(int id, String name, Integer price, String pic, boolean isActive, Location location, int totalCount) {
        super(id, name, price, pic, isActive, location, totalCount);
    }

    public StageItem(int id, int quantity) {
        super(id, quantity);
    }

    public StageItem() {
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }
}

