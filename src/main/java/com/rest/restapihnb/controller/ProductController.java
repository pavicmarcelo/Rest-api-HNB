package com.rest.restapihnb.controller;

import com.rest.restapihnb.model.Product;
import com.rest.restapihnb.repository.ProductRepo;
import com.rest.restapihnb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;



    @RequestMapping(value = "/createProduct", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    Product creatingProduct(@RequestBody Product product) throws Exception {

        return productService.createProduct(product);
    }


    public BigDecimal calculateFromHrkToEur(Product product, ExchangeHNBController exchangeHNBController) throws Exception {

        BigDecimal priceInEuro;

        priceInEuro = product.getPrice_hrk().divide(exchangeHNBController.getSrednjiTecajFromHNBApi(), RoundingMode.CEILING);


        return priceInEuro;
    }


    @RequestMapping(value = "/product/{code}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Product getProductByCode(
            @PathVariable(value = "code") final String code) {

        return productService.getProductByCode(code);
    }




}
