package com.murpol.invoicegenerator.components.hexagonalelements.repositories;

import com.murpol.invoicegenerator.components.entity.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoInvoiceRepository extends MongoRepository<Invoice, String> {
}
