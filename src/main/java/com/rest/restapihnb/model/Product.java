package com.rest.restapihnb.model;



import com.rest.restapihnb.controller.ExchangeHNBController;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


@Table(name = "products")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class Product {


    @Id
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "code", unique = true, length = 10)
    private String code;
    private String name;
    private BigDecimal price_hrk;
    private BigDecimal price_eur;
    private String description;
   // private Boolean isAvailable;



/*
    public Product (String code, String name, BigDecimal price_hrk, String description, Boolean isAvailable) {   // izbaciti

        ExchangeHNBController exchangeHNBController = new ExchangeHNBController();

        this.code = code;
        this.name = name;
        this.price_hrk = price_hrk.setScale(2, RoundingMode.HALF_EVEN);
        try {
            this.price_eur = price_hrk.divide(exchangeHNBController.getSrednjiTecajFromHNBApi(), 2, RoundingMode.CEILING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.description = description;
        this.isAvailable = isAvailable;
    }

*/




}
