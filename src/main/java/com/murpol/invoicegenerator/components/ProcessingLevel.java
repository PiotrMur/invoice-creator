package com.murpol.invoicegenerator.components;

enum ProcessingLevel {

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
