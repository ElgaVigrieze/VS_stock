package com.company.springmvcweb.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity(name = "ProjectStockList")
@Table(name="project_stock_list")
@NoArgsConstructor
public class ProjectStockListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "project_id")
    private int projectId;
    @Column(name = "item_id")
    private int stockListItemId;


}

