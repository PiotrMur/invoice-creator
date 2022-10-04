package com.murpol.invoicegenerator.components;

import org.springframework.data.mongodb.repository.MongoRepository;

interface MongoInvoiceRepository extends MongoRepository<Invoice, String> {
}
