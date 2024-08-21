package com.nero.java_enterprise_project.controller;

import com.nero.java_enterprise_project.model.Product;
import com.nero.java_enterprise_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/products")
public class ProductWebController {

    @Autowired
    private ProductService productService;

    @GetMapping("/view/{id}")
    public String getProductById(@PathVariable Long id, Model model) {
        return productService.getProductById(id)
                .map(product -> {
                    model.addAttribute("product", product);
                    return "product";
                })
                .orElse("error/404");
    }
}
