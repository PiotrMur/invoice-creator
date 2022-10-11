package com.murpol.invoicegenerator.components.restcomponents;

import com.murpol.invoicegenerator.components.invoice.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoInvoiceRepository extends MongoRepository<Invoice, String> {
}

//zresygnowac z warstyw invoice repostitory i implementacji lub zmienic implementacje api i skierowac
// je do Invoice Service - wykorzystac do tego dodatkowy branch
//podziel na pakiety
