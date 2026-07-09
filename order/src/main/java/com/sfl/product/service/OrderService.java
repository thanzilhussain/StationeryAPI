package com.sfl.product.service;


import com.sfl.product.DTO.ProductDTO;
import com.sfl.product.entity.Order;
import com.sfl.product.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService implements OrderServiceInterface {

    @Autowired
    private OrderRepo orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(int id){
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order saveOrder(Order order) {

        ProductDTO product = restTemplate.getForObject(
                "http://localhost:8080/api/v1/product/name/" + order.getProductName(),
                ProductDTO.class);

        if (product == null) {
            return null;
        }

        order.setProductId(product.getId());
        order.setProductPrice(product.getProductPrice());
        order.setProductName(product.getProductName());

        order.setTotalPrice(product.getProductPrice() * order.getQuantity());

        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(int id, Order order) {

        Order existing = orderRepository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        ProductDTO product = restTemplate.getForObject(
                "http://localhost:8080/product/name/" + order.getProductName(),
                ProductDTO.class);

        if (product == null) {
            return null;
        }

        existing.setCustName(order.getCustName());

        existing.setProductId(product.getId());
        existing.setProductName(product.getProductName());
        existing.setProductPrice(product.getProductPrice());

        existing.setQuantity(order.getQuantity());

        existing.setTotalPrice(product.getProductPrice() * order.getQuantity());

        return orderRepository.save(existing);
    }

    @Override
    public String deleteOrderById(int id) {
        if (!orderRepository.existsById(id)) {
            return "There is no order with id " + id;
        }
        orderRepository.deleteById(id);
        return "Order with id " + id + " was deleted";
    }
}