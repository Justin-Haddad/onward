package com.onward.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.onward.app.repositories.Invoice;
import com.onward.app.services.InvoiceService;
import java.util.List;

//Coded By Ruben Macedo for ticket 5: Invoices
@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    // Other controller methods for handling HTTP requests
}