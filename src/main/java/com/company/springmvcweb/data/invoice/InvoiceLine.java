//package com.company.springmvcweb.data.invoice;
//
//import com.company.springmvcweb.data.project.Project;
//
//import javax.persistence.*;
//
//public class InvoiceLine {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    @Column(name="id", unique = true, nullable = false)
//    private long id;
//    @ManyToOne
//    private Invoice invoice;
//    @Column(name="description")
//    private String description;
//    @Column(name="price")
//    private float price;
//    @Column(name="quantity")
//    private int quantity;
//    @Column(name="sum")
//    private float sum;
//    @OneToOne
//    @JoinColumn(name = "project_id")
//    private Project project;
//
//
//}
