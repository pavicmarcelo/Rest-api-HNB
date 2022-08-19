package com.rest.restapihnb.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Data
public class ExchangeHNB implements Serializable {

    @Id
    @JsonIgnore
    private Long id;   // javeBeans imaju private fields i moraju imati gettere ili settere
    @JsonProperty("Broj tečajnice")
    private String brojTecajnice;
    @JsonProperty("Datum primjene")
    private String datumPrimjene;
    @JsonProperty("Država")
    private String drzava;
    @JsonProperty("Šifra valute")
    private String sifraValute;
    @JsonProperty("Valuta")
    private String valuta;
    @JsonProperty("Jedinica")
    private String jedinica;
    @JsonProperty("Kupovni za devize")
    private String kupivniZaDevize;
    @JsonProperty("Srednji za devize")
    private String srednjiZaDevize;
    @JsonProperty("Prodajni za devize")
    private String prodajniZaDevize;

}
