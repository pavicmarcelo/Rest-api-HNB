package com.rest.restapihnb.controller;

import com.rest.restapihnb.model.Product;
import com.rest.restapihnb.repository.ProductRepo;
import com.rest.restapihnb.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Validated
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    ExchangeHNBController exchangeHNBController = new ExchangeHNBController();

    @RequestMapping(value = "/create-product", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    Product creatingProduct(@RequestBody Product product) throws Exception {

        product.setPrice_eur(product.getPrice_hrk().divide(exchangeHNBController.getSrednjiTecajFromHNBApi(), RoundingMode.CEILING) );

        return productService.createProduct(product);
    }






    public BigDecimal calculateFromHrkToEur(Product product, ExchangeHNBController exchangeHNBController) throws Exception {

        BigDecimal priceInEuro;

        priceInEuro = product.getPrice_hrk().divide(exchangeHNBController.getSrednjiTecajFromHNBApi(), RoundingMode.CEILING);


        return priceInEuro;
    }


    @RequestMapping(value = "/testSrednji", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public void testMethod() {


        ExchangeHNBController exchangeHNBController = new ExchangeHNBController();
        BigDecimal srednjiTecaj;

        try {
            srednjiTecaj = exchangeHNBController.getSrednjiTecajFromHNBApi();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main srednji: " + srednjiTecaj);

        MathContext m = new MathContext(2); // 4 precision

        BigDecimal cijena = ( new BigDecimal(15.49) ).setScale(2, RoundingMode.HALF_UP);  //HALF_EVEN

    //    Product product = new Product(1l, "code1", "racunalo", cijena, null ,"opis", true);

        Product product = new Product(5l, "code1", "racunalo", cijena, cijena ,"opis");

        product.setPrice_eur(product.getPrice_hrk().divide(srednjiTecaj, 2, RoundingMode.HALF_UP) );

        System.out.println("produkt je: " + product);



    }



/*

    @RequestMapping(value = "/product/{code}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Product getProductByCode(
            @PathVariable(value = "code") final String code) {

        return productService.getProductByCode(code);
    }

*/


}
