package com.rest.restapihnb.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Entity
@JsonClassDescription
@JsonFormat
public class ExchangeHNB implements Serializable {

    @Id
    private Long id;   // javeBeans imaju private fields i moraju imati gettere ili settere
    private String brojTecajnice;
    @JsonFormat(pattern="dd.MM.yyyy")
    private LocalDate datumPrimjene;
    private String drzava;
    private String sifraValute;
    private String valuta;
    private Long jedinica;
    private String kupivniZaDevize;
    private String srednjiZaDevize;
    private String prodajniZaDevize;



    public ExchangeHNB(String brojTecajnice, LocalDate datumPrimjene, String drzava, String sifraValute, String valuta, Long jedinica, String kupivniZaDevize, String srednjiZaDevize, String prodajniZaDevize) {
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

    public LocalDate getDatumPrimjene() {
        return datumPrimjene;
    }

    public void setDatumPrimjene(LocalDate datumPrimjene) {
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

    public Long getJedinica() {
        return jedinica;
    }

    public void setJedinica(Long jedinica) {
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


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
