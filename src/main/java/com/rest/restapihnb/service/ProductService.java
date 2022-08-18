package com.rest.restapihnb.service;

import com.rest.restapihnb.controller.ExchangeHNBController;
import com.rest.restapihnb.model.Product;
import com.rest.restapihnb.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Service
public class ProductService {


    @Autowired
    ProductRepo productRepo;


    ExchangeHNBController exchangeHNBController;





    public Product createProduct(Product product) {

      //  BigDecimal priceInEUR = exchangeHNBService.calculateFromHrkToEur(product);

      //  product.setPrice_eur(priceInEUR);

        return productRepo.save(product);

    }



    @RequestMapping(value = "/getProduct/{code}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Product getProductByCode(
            @PathVariable(value = "code") final String code) {

        return productRepo.getProductByCode(code);
    }




    @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Product> getAllProducts() {

        return productRepo.findAll();
    }






}
