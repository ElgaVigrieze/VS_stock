package com.company.springmvcweb.data;

import com.company.springmvcweb.data.invoice.Invoice;

import java.util.*;

public class Main {
    public static void main(String... args) {
        var repo = new InvoiceRepository();
        var in = (Invoice)repo.getInvoice(9);
        var invo = repo.getInvoices();
        ArrayList<Invoice>invoices = new ArrayList<>();
        for (var i: invo) {
//            var it = (Invoice)i;
            invoices.add(i);
//            System.out.println("number "+ i.getNumber());
//            System.out.println("project "+i.getProject());
//            System.out.println("describe "+i.getDescription());
//            System.out.println("customer "+i.getCustomer());
        }
        var invoice = invoices.get(2);
//        System.out.println(invoice);
        System.out.println(invoice.getDate());


    }

}