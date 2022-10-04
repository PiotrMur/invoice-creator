package com.murpol.invoicegenerator.components;

public class GenerateInvoiceDTO {

    private PersonalInfo personalInfo;
    private FinancialData financialData;

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
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
