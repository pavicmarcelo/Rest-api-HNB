package com.rest.restapihnb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.math.BigDecimal;
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


    public Product (String code, String name, BigDecimal price_hrk, String description) {
        this.code = code;
        this.name = name;
        this.price_hrk = price_hrk.setScale(2, RoundingMode.HALF_EVEN);
        this.description = description;
    }


}
