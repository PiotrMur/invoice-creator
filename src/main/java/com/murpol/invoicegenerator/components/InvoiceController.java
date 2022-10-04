package com.murpol.invoicegenerator.components;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/invoices")
class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<Invoice> showAll(){
        return invoiceService.showAllInvoices();
    }

    @GetMapping(path = "{gettingInvoiceId}")
    public Invoice getInvoice(@PathVariable (name = "gettingInvoiceId") String gettingInvoiceId){
        return invoiceService.getInvoiceById(gettingInvoiceId);
    }

    @DeleteMapping(path = "{invoiceId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteInvoice(@PathVariable(name = "invoiceId") String invoiceId){
        invoiceService.deleteInvoice(invoiceId);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void generateInvoice(@RequestBody Invoice invoice){
        invoiceService.createPDF(invoice);
    }

}
