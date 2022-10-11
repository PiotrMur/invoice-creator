package com.murpol.invoicegenerator.components.infoclasses;

public enum ProcessingLevel {

    SENT("Sent"),
    SAVED("Saved");


    private final String status;


    ProcessingLevel(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
