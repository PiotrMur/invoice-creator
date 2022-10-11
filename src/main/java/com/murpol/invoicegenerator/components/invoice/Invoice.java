package com.murpol.invoicegenerator.components.invoice;

import com.murpol.invoicegenerator.components.infoclasses.FinancialInfo;
import com.murpol.invoicegenerator.components.infoclasses.PersonalInfo;
import com.murpol.invoicegenerator.components.infoclasses.TechnicalInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Invoice {

    @Id
    private String id = IdGenerator.generateInvoiceNumber();
    private final PersonalInfo personalInfo;
    private final FinancialInfo financialInfo;
    private final TechnicalInfo technicalInfo;

    //sprawdz pola final - program dziala bez pustego konstruktora i z polami final dla wszystkich poza id, ponieważ final wymusza brak settera,
    // a bez niego nie da się ustawić wygenereowanej wartosci dla ID

    public Invoice(PersonalInfo personalInfo, FinancialInfo financialInfo, TechnicalInfo technicalInfo) {
        this.personalInfo = personalInfo;
        this.financialInfo = financialInfo;
        this.technicalInfo = technicalInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PersonalInfo getPersonalData() {
        return personalInfo;
    }

    public FinancialInfo getFinancialData() {
        return financialInfo;
    }

    public TechnicalInfo getTechnicalData() {
        return technicalInfo;
    }

    @Override
    public String toString() {
        return "GenerateInvoiceDTO{" +
                "id='" + id + '\'' +
                ", personalData=" + personalInfo +
                ", financialData=" + financialInfo +
                ", technicalData=" + technicalInfo +
                '}';
    }
}
