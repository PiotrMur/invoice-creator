package com.murpol.invoicegenerator.components.hexagonalelements;

import com.murpol.invoicegenerator.components.entity.IdGenerator;
import com.murpol.invoicegenerator.components.entity.Invoice;
import com.murpol.invoicegenerator.components.hexagonalelements.repositories.InvoiceRepository;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class InvoiceService {

    private InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    private static final Logger LOG = LoggerFactory.getLogger(InvoiceService.class);

    public List<Invoice> showAllInvoices(){
        return invoiceRepository.fetchAll();
    }

    public Invoice getInvoiceById(String gettingInvoiceId){
        return invoiceRepository.fetchById(gettingInvoiceId);
    }

    public void deleteInvoice(String invoiceId){
        invoiceRepository.delete(invoiceId);
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

        generatePDF(invoiceData);
        invoiceRepository.save(invoice);
    }

    private void generatePDF(List<String> invoiceData) {
        try (PDDocument doc = new PDDocument()) {

            PDDocumentInformation information = new PDDocumentInformation();
            information.setAuthor("Piotr Murawski");
            information.setTitle("Invoice");
            information.setCreator("Invoice generator");

            Calendar date = Calendar.getInstance();
            information.setCreationDate(date);
            information.setModificationDate(date);

            PDPage myPage = new PDPage();
            doc.addPage(myPage);

            try (PDPageContentStream cont = new PDPageContentStream(doc, myPage)) {

                cont.beginText();

                cont.setFont(PDType1Font.TIMES_ROMAN, 12);
                cont.setLeading(14.5f);

                cont.newLineAtOffset(25, 700);
                String invoiceNumber = String.format("Invoice's number: %s", IdGenerator.generateInvoiceNumber());
                cont.showText(invoiceNumber);

                cont.newLine();

                String name = String.format("Name and Surname of invoice's issuer: %s %s", invoiceData.get(0), invoiceData.get(1));
                cont.showText(name);

                cont.newLine();

                String receipient = "Invoice's recepient: ";
                cont.showText(receipient);

                cont.newLine();

                String amount = String.format("Amount in %s: %s", invoiceData.get(3), invoiceData.get(2));
                cont.showText(amount);

                cont.newLine();

                String invoiceDate = String.format("Invoice's issue date: %s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("d.MM.uuuu")));
                cont.showText(invoiceDate);

                cont.endText();
            }
            doc.save("src/main/resources/invoice" + IdGenerator.generateInvoiceNumber() + ".pdf");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}