package com.nero.java_enterprise_project.service;

import com.nero.java_enterprise_project.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product saveProduct(Product product);
    Optional<Product> getProductById(Long id);
    List<Product> getAllProducts();
    void deleteProduct(Long id);

}
