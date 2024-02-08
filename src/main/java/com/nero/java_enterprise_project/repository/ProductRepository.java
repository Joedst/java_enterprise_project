package com.nero.java_enterprise_project.repository;



import com.nero.java_enterprise_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}

