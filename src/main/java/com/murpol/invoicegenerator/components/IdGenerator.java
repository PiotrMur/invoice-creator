package com.murpol.invoicegenerator.components;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class IdGenerator {

    private IdGenerator(){

    }

    static String generateInvoiceNumber() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("uuMMddHHmmss"));
    }
}
