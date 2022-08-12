package com.rest.restapihnb.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserProductDTO {

    private long userId;
    private String email;
    private String code;
    private String name;
    private BigDecimal price;



}
