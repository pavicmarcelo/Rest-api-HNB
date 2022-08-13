package com.rest.restapihnb;

import com.rest.restapihnb.controller.ExchangeHNBController;
import com.rest.restapihnb.controller.ProductController;
import com.rest.restapihnb.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.math.BigDecimal;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RestApiHnbApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiHnbApplication.class, args);




        Product product = new Product(1l, "code1", "racunalo", new BigDecimal(45.34), new BigDecimal(0), "opis", true);


        ProductController productController = new ProductController();

        try {
            productController.creatingProduct(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
