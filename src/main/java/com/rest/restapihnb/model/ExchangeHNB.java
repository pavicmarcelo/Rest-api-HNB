package com.rest.restapihnb.model;

import com.fasterxml.jackson.annotation.*;
import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;



@JsonClassDescription
@JsonFormat
@Entity
public class ExchangeHNB implements Serializable {

    @Id
    @JsonIgnore
    private Long id;   // javeBeans imaju private fields i moraju imati gettere ili settere
    @JsonProperty("Broj tečajnice")
    private String brojTecajnice;
    @JsonProperty("Datum primjene")
   // @JsonFormat(pattern="dd.MM.yyyy")
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


    public ExchangeHNB(String brojTecajnice, String datumPrimjene, String drzava, String sifraValute, String valuta, String jedinica, String kupivniZaDevize, String srednjiZaDevize, String prodajniZaDevize) {
        this.brojTecajnice = brojTecajnice;
        this.datumPrimjene = datumPrimjene;
        this.drzava = drzava;
        this.sifraValute = sifraValute;
        this.valuta = valuta;
        this.jedinica = jedinica;
        this.kupivniZaDevize = kupivniZaDevize;
        this.srednjiZaDevize = srednjiZaDevize;
        this.prodajniZaDevize = prodajniZaDevize;
    }

    public ExchangeHNB() {
    }


    @Override
    public String toString() {
        return "ExchangeHNB{" +
                "brojTecajnice='" + brojTecajnice + '\'' +
                ", datumPrimjene=" + datumPrimjene +
                ", drzava='" + drzava + '\'' +
                ", sifraValute='" + sifraValute + '\'' +
                ", valuta='" + valuta + '\'' +
                ", jedinica=" + jedinica +
                ", kupivniZaDevize='" + kupivniZaDevize + '\'' +
                ", srednjiZaDevize='" + srednjiZaDevize + '\'' +
                ", prodajniZaDevize='" + prodajniZaDevize + '\'' +
                '}';
    }

    public String getBrojTecajnice() {
        return brojTecajnice;
    }

    public void setBrojTecajnice(String brojTecajnice) {
        this.brojTecajnice = brojTecajnice;
    }

    public String getDatumPrimjene() {
        return datumPrimjene;
    }

    public void setDatumPrimjene(String datumPrimjene) {
        this.datumPrimjene = datumPrimjene;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getSifraValute() {
        return sifraValute;
    }

    public void setSifraValute(String sifraValute) {
        this.sifraValute = sifraValute;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public String getJedinica() {
        return jedinica;
    }

    public void setJedinica(String jedinica) {
        this.jedinica = jedinica;
    }

    public String getKupivniZaDevize() {
        return kupivniZaDevize;
    }

    public void setKupivniZaDevize(String kupivniZaDevize) {
        this.kupivniZaDevize = kupivniZaDevize;
    }

    public String getSrednjiZaDevize() {
        return srednjiZaDevize;
    }

    public void setSrednjiZaDevize(String srednjiZaDevize) {
        this.srednjiZaDevize = srednjiZaDevize;
    }

    public String getProdajniZaDevize() {
        return prodajniZaDevize;
    }

    public void setProdajniZaDevize(String prodajniZaDevize) {
        this.prodajniZaDevize = prodajniZaDevize;
    }



}
