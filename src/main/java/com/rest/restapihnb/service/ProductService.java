package com.rest.restapihnb.service;

import com.rest.restapihnb.controller.ExchangeHNBController;
import com.rest.restapihnb.controller.ProductController;
import com.rest.restapihnb.dto.UserProductDTO;
import com.rest.restapihnb.model.Product;
import com.rest.restapihnb.model.User;
import com.rest.restapihnb.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;



public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    ExchangeHNBController exchangeHNBController;




    public Product createProduct(Product product) throws Exception {

        BigDecimal priceInEUR = exchangeHNBController.getSrednjiTecajFromHNBApi();

        product.setPrice_eur(priceInEUR);

        productRepo.save(product);

        return product;
    }



    @RequestMapping(value = "/getProduct/{code}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Product getProductByCode(
            @PathVariable(value = "code") final String code) {

        return productRepo.getProductByCode(code);
    }





    public List<Product> getAllProducts() {

        return productRepo.findAll();
    }



}
