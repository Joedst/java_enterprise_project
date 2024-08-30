package com.nero.java_enterprise_project.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.put(product, products.getOrDefault(product, 0) + 1);
    }

    public void removeProduct(Product product) {
        if (products.containsKey(product)) {
            if (products.get(product) > 1) {
                products.put(product, products.get(product) - 1);
            } else {
                products.remove(product);
            }
        }
        System.out.println("Attempting to remove product: " + product);
        System.out.println("Current products in cart: " + products);

        if (products.containsKey(product)) {
            System.out.println("Product found in cart. Quantity before removal: " + products.get(product));

            if (products.get(product) > 1) {
                products.put(product, products.get(product) - 1);
                System.out.println("Reduced quantity. New quantity: " + products.get(product));
            } else {
                products.remove(product);
                System.out.println("Removed product from cart.");
            }
        } else {
            System.out.println("Product not found in cart.");
        }

        System.out.println("Current products in cart after removal attempt: " + products);

    }

    public void clearCart() {
        products.clear();
    }

    public double getTotalPrice() {
        return products.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
}
