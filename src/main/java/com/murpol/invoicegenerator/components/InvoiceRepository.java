package com.murpol.invoicegenerator.components;

import java.util.List;

public interface InvoiceRepository {

    List<Invoice> fetchAll();
    Invoice fetchById(String invoiceId);
    void delete(String invoiceId);
    void save(Invoice invoice);
}
