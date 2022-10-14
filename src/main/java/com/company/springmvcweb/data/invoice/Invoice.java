//package com.company.springmvcweb.data.invoice;
//
//import com.company.springmvcweb.data.*;
//import com.company.springmvcweb.data.enums.DocType;
//import lombok.*;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//@Data
//@Getter
//@Setter
//@Entity(name="Invoice")
//@AllArgsConstructor
//@NoArgsConstructor
//public class Invoice {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    @Column(name="id", unique = true, nullable = false)
//    private long id;
//    @Enumerated
//    private DocType type;
//    @Column(name="number")
//    private String number;
//    @Column(name="date")
//    private LocalDate date;
//    @Column(name="due_date")
//    private LocalDate dueDate;
//    @ManyToOne
////    @JoinTable(name="customer", joinColumns=@JoinColumn(name="id"), inverseJoinColumns=@JoinColumn(name="customer_id"))
//    private Customer customer;
//    @Column(name="total")
//    private Float total;
//    @Column(name="comment")
//    private String comment;
//    @OneToMany(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
//    @JoinTable(name="invoice_item", joinColumns=@JoinColumn(name="invoice_id"), inverseJoinColumns=@JoinColumn(name="id"))
//    ArrayList<InvoiceLine> lines;
//
//
//    public Invoice(long id, DocType type, Customer customer, String comment) { //type invoice
//        this.id = id;
//        this.type = type;
//        this.customer = customer;
//        this.comment=comment;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
////    public float calculateSum() {
////        var repo = new ItemRepository();
////        var repo1 = new ProjectRepository();
////  //      var project = (Project)repo1.getProject((int)projectId);
////        var items = repo1.getStockListItemsSorted(project);
////        return repo.getProjectSum(items);
////    }
//
//    public String numberGenerator(){
//        var year = String.valueOf(LocalDate.now().getYear());
//        var repo = new InvoiceRepository();
//        var lastInvoice = (Invoice)repo.getLastInvoice();
//        var lastInvoiceNumber = lastInvoice.getNumber();
//        var lastInvoiceLastDigits = lastInvoiceNumber.substring(lastInvoice.getNumber().lastIndexOf("/")+1);
//        var lastNumber = Integer.parseInt(lastInvoiceLastDigits);
//        return "VS"+ year.substring(2,4)+"/" + (lastNumber+1);
//    }
//}
