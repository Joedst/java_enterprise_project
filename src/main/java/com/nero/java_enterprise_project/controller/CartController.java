package com.nero.java_enterprise_project.controller;

import com.nero.java_enterprise_project.model.Cart;
import com.nero.java_enterprise_project.model.Product;
import com.nero.java_enterprise_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart getCart() {
        return new Cart();
    }

    @GetMapping
    public String viewCart(@ModelAttribute("cart") Cart cart, Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/add/{productId}")
    public String addToCart(@PathVariable("productId") Long productId, @ModelAttribute("cart") Cart cart) {
        productService.getProductById(productId).ifPresent(cart::addProduct);
        return "redirect:/cart";
    }

    @GetMapping("/remove/{productId}")
    public String removeFromCart(@PathVariable("productId") Long productId, @ModelAttribute("cart") Cart cart) {
        productService.getProductById(productId).ifPresent(cart::removeProduct);
        return "redirect:/cart";
    }
}
