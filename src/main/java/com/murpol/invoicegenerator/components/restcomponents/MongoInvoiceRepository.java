package com.murpol.invoicegenerator.components.restcomponents;

import com.murpol.invoicegenerator.components.invoice.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoInvoiceRepository extends MongoRepository<Invoice, String> {
}
