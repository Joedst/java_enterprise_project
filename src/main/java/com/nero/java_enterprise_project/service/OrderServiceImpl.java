package com.nero.java_enterprise_project.service;


import com.nero.java_enterprise_project.model.Order;
import com.nero.java_enterprise_project.model.Product;
import com.nero.java_enterprise_project.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

@Autowired
public OrderServiceImpl(OrderRepository orderRepository){
    this.orderRepository = orderRepository;
}


    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
