package com.nero.java_enterprise_project.controller;


import com.nero.java_enterprise_project.model.Order;
import com.nero.java_enterprise_project.model.Product;
import com.nero.java_enterprise_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
Product savedProduct = productService.saveProduct(product);
return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/product/{id}")
        public ResponseEntity<Product> getProductById(@PathVariable Long id){

        return productService.getProductById(id)
        .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


@DeleteMapping("/product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
}


}
