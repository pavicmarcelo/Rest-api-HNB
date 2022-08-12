package com.rest.restapihnb.repository;

import com.rest.restapihnb.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {


}
