package com.company.springmvcweb.data;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name ="StockListItem")
@Table(name ="stock_list")
public class StockListItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="item_id")
    private int itemId;
    @Column(name="item_quantity")
    private int itemQuantity;
    @Column(name="item_done")
    private boolean itemDone;
    @ManyToOne(cascade=CascadeType.ALL)
    public Project project;


}


