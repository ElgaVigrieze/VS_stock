package com.company.springmvcweb;

import com.company.springmvcweb.data.*;
import com.company.springmvcweb.data.enums.DocType;
import com.company.springmvcweb.data.invoice.Invoice;
import com.company.springmvcweb.data.project.Project;
import com.company.springmvcweb.data.utilities.PdfFileExporter;
import com.company.springmvcweb.dto.InvoiceSaveDto;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.company.springmvcweb.data.utilities.PreparePdfData.setPdfDataInvoice;

@Controller
public class InvoiceController {
    private InvoiceRepository repo;
    private ProjectRepository repo1;
    private CustomerRepository repo2;

    public InvoiceController() {
        repo = new InvoiceRepository();
        repo1 = new ProjectRepository();
        repo2 = new CustomerRepository();
    }

    @GetMapping("/new_invoice")
    public String addInvoice(Model model) {
        DocType[] docTypes = DocType.values();
        List<String> types = new ArrayList<>();
        for (var t : docTypes) {
            types.add(t.getValue());
        }
        Iterable<Project> projects = repo1.getProjects();
        Iterable<Customer> customers = repo2.getCustomers();
        model.addAttribute("title", "Izveidot jaunu rēķinu");
        model.addAttribute("types", types);
        model.addAttribute("projects", projects);
        model.addAttribute("customers", customers);
        model.addAttribute("invoice", new Invoice());
//        model.addAttribute("projectId", projectId);
        return "new_invoice";
    }

    @PostMapping("/new_invoice")
    public ModelAndView addInvoice(InvoiceSaveDto dto, @PathVariable long invoiceId) {
        invoiceId = repo.addInvoice(dto);
        return new ModelAndView("redirect:/invoices/{invoiceId}/preview");
    }

    @GetMapping("/invoices/{invoiceId}/preview")
    public ResponseEntity<InputStreamResource> viewPdf(@PathVariable long invoiceId) throws IOException {
        var invoice = (Invoice)repo.getInvoice(invoiceId);
        var number = invoice.getNumber().replace("/","_");
        PdfFileExporter pdfFileExporter = new PdfFileExporter();
        Map<String, Object> data = setPdfDataInvoice(invoiceId);
        String pdfFileName = "C:\\jar\\pdf\\invoices\\invoice_"+number+".pdf";

        return pdfFileExporter.showPdfFilePreview("invoice", data, pdfFileName);
    }

    @GetMapping("/invoices")
    public String invoices(Model model) {
        var invoices = repo.getInvoices();
        var invoice = new Invoice();
        model.addAttribute("invoices", invoices);
        model.addAttribute("invoice", invoice);
        return "invoices";

    }

    @GetMapping("/invoice")
    public String invoice(Model model) {
        var invoice = repo.getInvoice(24);

        model.addAttribute("invoice", invoice);
        return "invoice";

    }
}
