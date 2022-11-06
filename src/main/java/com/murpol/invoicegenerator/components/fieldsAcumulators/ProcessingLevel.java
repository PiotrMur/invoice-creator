package com.murpol.invoicegenerator.components.fieldsAcumulators;

enum ProcessingLevel {

    SENT("Sent"),
    SAVED("Saved"),
    PAID("Paid"),
    PARTIALLYPAID("PartiallyPaid");


    private final String status;


    ProcessingLevel(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
