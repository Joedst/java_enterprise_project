package com.nero.java_enterprise_project.controller;

import com.nero.java_enterprise_project.model.Order;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import com.nero.java_enterprise_project.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")

public class OrderController {


    private final OrderService orderService;

    @Autowired

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {

    Order savedOrder = orderService.saveOrder(order);
     return new ResponseEntity<>(savedOrder,HttpStatus.CREATED);
}

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {

        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    //getall orders

    //deletemapping
@DeleteMapping("/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable Long id)
{
     orderService.deleteOrder(id);
    return ResponseEntity.ok().build();
}



}
