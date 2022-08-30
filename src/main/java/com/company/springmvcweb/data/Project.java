package com.company.springmvcweb.data;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity(name="Project")
@Table(name="project")
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="location")
    private String location;
    @Column(name="date")
    private LocalDate date;
    @Column(name="description")
    private String description;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="stock_list", joinColumns=@JoinColumn(name="project_id"), inverseJoinColumns=@JoinColumn(name="item_id"))
    private List<StockListItem> items;

    public Project(int id, String title, String location, LocalDate date, String description) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.date = date;
        this.description = description;
    }

    public void setItem(StockListItem item){
        items.add(item);
    }

    public List<StockListItem> getItems() {
        return items;
    }
}