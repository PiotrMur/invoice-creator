package com.murpol.invoicegenerator.components;

import com.murpol.invoicegenerator.components.hexagonalelements.InvoiceService;
import com.murpol.invoicegenerator.components.hexagonalelements.repositories.InMemoryInvoiceRepository;
import com.murpol.invoicegenerator.components.hexagonalelements.repositories.InvoiceRepository;
import com.murpol.invoicegenerator.components.hexagonalelements.repositories.MongoInvoiceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InvoiceAppConfig {


    @Bean
    InvoiceService invoiceService(MongoInvoiceRepository mongoInvoiceRepository){
        //InvoiceRepository invoiceRepository = new InvoiceJPARepository(mongoInvoiceRepository);
        InvoiceRepository invoiceRepository = new InMemoryInvoiceRepository();
        return new InvoiceService(invoiceRepository);
    }

}
