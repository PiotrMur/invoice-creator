package com.murpol.invoicegenerator.components.invoice;

import com.murpol.invoicegenerator.components.infoclasses.FinancialInfo;
import com.murpol.invoicegenerator.components.infoclasses.PersonalInfo;
import com.murpol.invoicegenerator.components.infoclasses.TechnicalInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Invoice {



    // usun generator numerow faktury. Kazdy ma wybierac sobie format numeru faktury. Mongo moze sobie samo tworzyc (id systemowe),
    // ale uzytkownicy maja wybierac swoj (id uzytkownika)


    // uzytwnik ma mozliwosc wyszukiwania wybranej faktury

    //zwracanie DTO zamiast calej encji np wyrzuc ID
    //zrob research domenowy - infomracje prawne o fakturach. W jaki sposob nalezy je tworzyc i czym sie kierowac

    //napisac testy. Sprawdz czy monog udostepnia baze do testowania i uzyj jej. Mozna popracowac z instacja testowa na dockerze

    @Id
    private String id = IdGenerator.generateInvoiceNumber();
    private PersonalInfo personalInfo;
    private FinancialInfo financialInfo;
    private TechnicalInfo technicalInfo;

    //sprawdz pola final - program dziala bez pustego konstruktora i z polami final dla wszystkich poza id, ponieważ final wymusza brak settera,
    // a bez niego nie da się ustawić wygenereowanej wartosci dla ID


    public Invoice() {
    }

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

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public FinancialInfo getFinancialInfo() {
        return financialInfo;
    }

    public TechnicalInfo getTechnicalInfo() {
        return technicalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public void setFinancialInfo(FinancialInfo financialInfo) {
        this.financialInfo = financialInfo;
    }

    public void setTechnicalInfo(TechnicalInfo technicalInfo) {
        this.technicalInfo = technicalInfo;
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
