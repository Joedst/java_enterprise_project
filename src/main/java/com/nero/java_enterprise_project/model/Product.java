package com.nero.java_enterprise_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String description;


    public Product() { //Tom för thymeleaf
    }

    public Product(Long id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public boolean equals(Object o) {
        if (this == o) return true; // Same memory reference
        if (o == null || getClass() != o.getClass()) return false; // Different class

        Product product = (Product) o;

        return id != null ? id.equals(product.id) : product.id == null; // Compare based on ID
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0; // Use ID for hash code
    }
}
