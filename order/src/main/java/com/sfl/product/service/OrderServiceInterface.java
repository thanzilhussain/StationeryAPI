package com.sfl.product.service;

import com.sfl.product.entity.Order;

import java.util.List;

public interface OrderServiceInterface {
    List<Order> getAllOrders();
    Order getOrderById(int id);
    Order saveOrder(Order order);
    Order updateOrder(int id,Order order);
    String deleteOrderById(int id);
}
