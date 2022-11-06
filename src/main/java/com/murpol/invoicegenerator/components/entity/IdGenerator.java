package com.murpol.invoicegenerator.components.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IdGenerator {

    private IdGenerator(){

    }

    public static String generateInvoiceNumber() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("uuMMddHHmmss"));
    }
}
