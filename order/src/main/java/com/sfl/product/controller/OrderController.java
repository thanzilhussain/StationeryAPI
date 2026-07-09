package com.sfl.product.controller;

import com.sfl.product.service.OrderService;
import com.sfl.product.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/api/v1/Orders")
    public List<Order> getAllOrders(){
        return service.getAllOrders();
    }
    @GetMapping("/api/v1/Orders/{id}")
    public Order getOrdersById(@PathVariable int id){
        return service.getOrderById(id);
    }
    @PostMapping("/api/v1/Orders")
    public Order postOrders(@RequestBody Order app){
        return service.saveOrder(app);
    }
    @PutMapping("/api/v1/Orders/{id}")
    public Order putOrders(@PathVariable int id, @RequestBody Order app){
        return service.updateOrder(id,app);
    }
    @DeleteMapping("/api/v1/Orders/{id}")
    public String deleteOrderById(@PathVariable int id){
        return service.deleteOrderById(id);
    }
}

