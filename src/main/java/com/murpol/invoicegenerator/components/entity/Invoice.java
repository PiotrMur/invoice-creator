package com.murpol.invoicegenerator.components.entity;

import com.murpol.invoicegenerator.components.entity.IdGenerator;
import com.murpol.invoicegenerator.components.fieldsAcumulators.FinancialData;
import com.murpol.invoicegenerator.components.fieldsAcumulators.PersonalData;
import com.murpol.invoicegenerator.components.fieldsAcumulators.TechnicalData;
import org.springframework.data.annotation.Id;

public class Invoice {

    @Id
    private String id = IdGenerator.generateInvoiceNumber();
    private PersonalData personalData;
    private FinancialData financialData;
    private TechnicalData technicalData;

    public Invoice() {
    }

    public Invoice(PersonalData personalData, FinancialData financialData, TechnicalData technicalData) {
        this.personalData = personalData;
        this.financialData = financialData;
        this.technicalData = technicalData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public FinancialData getFinancialData() {
        return financialData;
    }

    public void setFinancialData(FinancialData financialData) {
        this.financialData = financialData;
    }

    public TechnicalData getTechnicalData() {
        return technicalData;
    }

    public void setTechnicalData(TechnicalData technicalData) {
        this.technicalData = technicalData;
    }

    @Override
    public String toString() {
        return "GenerateInvoiceDTO{" +
                "id='" + id + '\'' +
                ", personalData=" + personalData +
                ", financialData=" + financialData +
                ", technicalData=" + technicalData +
                '}';
    }
}
