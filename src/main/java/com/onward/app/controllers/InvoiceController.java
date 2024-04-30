package com.onward.app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.onward.app.entities.Invoice;
import com.onward.app.services.InvoiceService;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


//Coded By Ruben Macedo for ticket 5: Invoices
@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/getinvoices")
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    // Other controller methods for handling HTTP requests

    //edit invoice names 
    //TODO by Id?
    @PutMapping("/editinvoice")
    public Invoice editInvoice(@RequestBody Invoice invoice) {
        return InvoiceService.updateInvoice(invoice);
    }
    //Delete Invoices by id
    @DeleteMapping("/deleteinvoice{id}")
    public void deleteInovice(@PathVariable Long id){
        invoiceService.deleteInoviceByID(id);
    }
}