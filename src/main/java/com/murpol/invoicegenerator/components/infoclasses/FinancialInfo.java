package com.murpol.invoicegenerator.components.infoclasses;

public class FinancialInfo {

    private String amount;
    private String currency;
    private String company;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "FinancialData{" +
                "amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
