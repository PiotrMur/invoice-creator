package com.murpol.invoicegenerator.components.hexagonalelements.repositories;

import com.murpol.invoicegenerator.components.entity.Invoice;

import java.util.List;

public class InMemoryInvoiceRepository implements InvoiceRepository {
    @Override
    public List<Invoice> fetchAll() {
        return null;
    }

    @Override
    public Invoice fetchById(String invoiceId) {
        return null;
    }

    @Override
    public void delete(String invoiceId) {

    }

    @Override
    public void save(Invoice invoice) {

    }
}
