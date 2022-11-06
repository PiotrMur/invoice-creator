package com.murpol.invoicegenerator.components.hexagonalelements;

import com.murpol.invoicegenerator.components.fieldsAcumulators.FinancialData;
import com.murpol.invoicegenerator.components.fieldsAcumulators.PersonalData;

public class GenerateInvoiceDTO {

    private PersonalData personalInfo;
    private FinancialData financialData;

    public PersonalData getPersonalData() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalData personalInfo) {
        this.personalInfo = personalInfo;
    }

    public FinancialData getFinancialData() {
        return financialData;
    }

    public void setFinancialData(FinancialData financialData) {
        this.financialData = financialData;
    }

    @Override
    public String toString() {
        return "GenerateInvoiceDTO{" +
                "personalInfo=" + personalInfo +
                ", financialData=" + financialData +
                '}';
    }
}
