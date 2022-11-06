package com.murpol.invoicegenerator.components.hexagonalelements.repositories;

import com.murpol.invoicegenerator.components.entity.Invoice;

import java.util.List;
import java.util.Optional;

public class InvoiceJPARepository implements InvoiceRepository {

    private final MongoInvoiceRepository mongoInvoiceRepository;

    public InvoiceJPARepository(MongoInvoiceRepository mongoInvoiceRepository) {
        this.mongoInvoiceRepository = mongoInvoiceRepository;
    }

    @Override
    public List<Invoice> fetchAll() {
        return mongoInvoiceRepository.findAll();
    }

    @Override
    public Invoice fetchById(String invoiceId) {
        Optional<Invoice> optionalInvoice = mongoInvoiceRepository.findById(invoiceId);
        if (optionalInvoice.isEmpty()) {
            throw new NullPointerException("There is no invoice with id: [" + invoiceId + "]");
        }
        return optionalInvoice.get();
    }

    @Override
    public void delete(String invoiceId) {
        Optional<Invoice> optionalInvoice = mongoInvoiceRepository.findById(invoiceId);
        if (optionalInvoice.isEmpty()) {
            throw new NullPointerException("There is no invoice with id: [" + invoiceId + "]");
        }
        mongoInvoiceRepository.deleteById(invoiceId);
    }

    @Override
    public void save(Invoice invoice) {
        mongoInvoiceRepository.save(invoice);
    }


    public void print() {
        System.out.println("hello");
    }
}
