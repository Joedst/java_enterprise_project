package com.nero.java_enterprise_project.repository;

import com.nero.java_enterprise_project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}

