package com.rest.restapihnb.controller;

import com.rest.restapihnb.model.Product;
import com.rest.restapihnb.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.RoundingMode;
import java.util.List;

@Validated
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    private ExchangeHNBController exchangeHNBController = new ExchangeHNBController();


    @RequestMapping(value = "/getProductByCode/{code}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Product getProductByCode(
            @PathVariable(value = "code") final String code) {

        return productService.getProductByCode(code);
    }


    @RequestMapping(value = "/findProductById/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    Product findById(@PathVariable(value = "id") final Long id) throws Exception {

        return productService.findById(id);
    }


    @RequestMapping(value = "/create-product", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    Product creatingProduct(@RequestBody Product product) throws Exception {

        product.setPrice_eur(product.getPrice_hrk().divide(exchangeHNBController.getSrednjiTecajFromHNBApi(), RoundingMode.CEILING) );

        return productService.createProduct(product);
    }


    @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }


    @RequestMapping(value = "/deleteProductById/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public void deleteProductById(
            @PathVariable(value = "id") final Long id) {

        productService.deleteProductById(id);
    }


}