package com.rest.restapihnb.service;

import com.rest.restapihnb.model.Product;
import com.rest.restapihnb.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    ProductRepo productRepo;


    public Product getProductByCode(String code) {
        return productRepo.getProductByCode(code);
    }


    public Product findById(Long id) throws Exception {

        Product productById = productRepo.findById(id).get();

        if (productById != null) {
            return productById;
        } else {
            throw new Exception("There is no product with that Id number.");
        }

    }


    public Product createProduct(Product product) {
        return productRepo.save(product);
    }


    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }


    public void deleteProductById(Long id) {
        productRepo.deleteById(id);
    }

}
