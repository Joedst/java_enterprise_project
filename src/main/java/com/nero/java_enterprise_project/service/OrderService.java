package com.nero.java_enterprise_project.service;

import com.nero.java_enterprise_project.model.Order;
import com.nero.java_enterprise_project.model.Product;

import java.util.List;
import java.util.Optional;

public interface OrderService {

        Order saveOrder(Order order);
        Optional<Order> getOrderById(Long id);
        List<Order> getAllOrders();
        void deleteOrder(Long id);


}
