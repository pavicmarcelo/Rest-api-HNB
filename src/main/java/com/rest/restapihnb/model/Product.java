package com.rest.restapihnb.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Table(name = "products")
@Data
@Entity
@NotNull  // provjeriti
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "code", unique = true, length = 10)
    private String code;
    private String name;
    private BigDecimal price_hrk;
    private BigDecimal price_eur;
  //  private BigDecimal ProductController;
    private String description;
    private Boolean isAvailable;



    public void setId(Long id) {
        this.id = id;
    }

    @javax.persistence.Id
    public Long getId() {
        return id;
    }
}
