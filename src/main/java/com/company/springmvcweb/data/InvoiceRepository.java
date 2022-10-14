//package com.company.springmvcweb.data;
//
//import com.company.springmvcweb.data.Items.*;
//import com.company.springmvcweb.data.invoice.Invoice;
//import com.company.springmvcweb.data.project.Project;
//import com.company.springmvcweb.data.project.StockListItem;
//import com.company.springmvcweb.dto.InvoiceSaveDto;
//import lombok.NonNull;
//import org.hibernate.HibernateException;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//import java.util.ArrayList;
//
//import static com.company.springmvcweb.data.enums.DocType.getType;
//
//public class InvoiceRepository {
//    private static SessionFactory factory;
//
//
//    public InvoiceRepository() {
//        try {
//            factory = new Configuration().
//                    configure().
//                    addAnnotatedClass(Invoice.class).
//                    addAnnotatedClass(Customer.class).
//                    addAnnotatedClass(Project.class).
//                    addAnnotatedClass(StockListItem.class).
//                    addAnnotatedClass(Item.class).
//                    buildSessionFactory();
//        } catch (Throwable ex) {
//            System.err.println("Failed to create sessionFactory object." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//
//    public Object getInvoice(long id) {
//
//        try (var session = factory.openSession()) {
//
//            var sql = "FROM Invoice where id = :id";
//            var query = session.createQuery(sql);
//            query.setParameter("id", id);
//
//            var items = query.list();
//
//            return items.size() > 0 ? items.get(0) : null;
//        } catch (HibernateException exception) {
//            System.err.println(exception);
//        }
//        return null;
//    }
//
//
//    public Iterable<Invoice> getInvoices() {
//        var session = factory.openSession();
//
//        try {
//            return session.createQuery("FROM Invoice").list();
//        } catch (HibernateException exception) {
//            System.err.println(exception);
//        } finally {
//            session.close();
//        }
//        return new ArrayList<>();
//    }
//
//    public Object getLastInvoice() {
//
//        try (var session = factory.openSession()) {
//            var sql = "FROM Invoice ORDER BY id DESC";
//            var query = session.createQuery(sql);
//            query.setMaxResults(1);
//            var items = query.list();
//
//            return items.size() > 0 ? items.get(0) : null;
//        } catch (HibernateException exception) {
//            System.err.println(exception);
//        }
//        return null;
//    }
//
//    public Long addInvoice(InvoiceSaveDto dto) {
//        var repo = new CustomerRepository();
//        var repo1 = new ProjectRepository();
//                var invoice = new Invoice(0, getType(dto.getType()),(Customer)repo.getCustomer(dto.getCustomerId()) ,dto.getDescription(), dto.getComment());
//                invoice.setNumber(invoice.numberGenerator());
//                if(dto.getProjectId()!= null){
//                    invoice.setProject((Project)repo1.getProject(dto.getProjectId()));
//                    invoice.setSum(invoice.calculateSum());
//                }
//                invoice.setSum(dto.getSum());
//                return addInvoice(invoice);
//    }
//
//
//    public Long addInvoice(@NonNull Invoice invoice){
//        var session = factory.openSession();
//        Long invoiceId = null;
//
//        try{
//            invoiceId = (Long)session.save(invoice);
//        }catch (HibernateException ex){
//            System.err.println(ex);
//        }finally{
//            session.close();
//        }
//        return invoiceId;
//    }
//
//}
