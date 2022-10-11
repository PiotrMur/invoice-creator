package com.murpol.invoicegenerator.components.restcomponents;

import com.murpol.invoicegenerator.components.invoice.Invoice;
import com.murpol.invoicegenerator.components.invoice.PdfGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
class InvoiceService {

    private MongoInvoiceRepository mongoInvoiceRepository;

    public InvoiceService(MongoInvoiceRepository mongoInvoiceRepository) {
        this.mongoInvoiceRepository = mongoInvoiceRepository;
    }

    private static final Logger LOG = LoggerFactory.getLogger(InvoiceService.class);

    public List<Invoice> showAllInvoices(){
        return mongoInvoiceRepository.findAll();

    }

    public Invoice getInvoiceById(String invoiceId){
        Optional<Invoice> optionalInvoice = mongoInvoiceRepository.findById(invoiceId);
        if (optionalInvoice.isEmpty()) {
            throw new IllegalArgumentException("There is no invoice with id: [" + invoiceId + "]");
        }
        return optionalInvoice.get();
    }

    public void deleteInvoice(String invoiceId){
        Optional<Invoice> optionalInvoice = mongoInvoiceRepository.findById(invoiceId);
        if (optionalInvoice.isEmpty()) {
            throw new IllegalArgumentException("There is no invoice with id: [" + invoiceId + "]");
        }
        mongoInvoiceRepository.deleteById(invoiceId);
    }

    public void createPDF(Invoice invoice) {

        List<String> invoiceData = new ArrayList<>();
        invoiceData.add(invoice.getPersonalData().getFirstName());
        invoiceData.add(invoice.getPersonalData().getLastName());
        invoiceData.add(invoice.getFinancialData().getAmount());
        invoiceData.add(invoice.getFinancialData().getCurrency());
        invoiceData.add(invoice.getFinancialData().getCompany());

        LOG.info("Personal info {}", invoice.getPersonalData());
        LOG.info("Financial data {}", invoice.getFinancialData());

        mongoInvoiceRepository.save(invoice);
        PdfGenerator.generatePDF(invoiceData);

    }



}