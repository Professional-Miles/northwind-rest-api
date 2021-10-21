package com.sparta.ml.northwindrest.controllers;

import com.sparta.ml.northwindrest.entities.OrderEntity;
import com.sparta.ml.northwindrest.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;;
    }

    @GetMapping("/northwind/orders")
    public List<OrderEntity> getAllOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/northwind/orders/{id}")
    public Optional<OrderEntity> getOrdersById(@PathVariable Integer id){
        return orderRepository.findById(id);
    }

}
