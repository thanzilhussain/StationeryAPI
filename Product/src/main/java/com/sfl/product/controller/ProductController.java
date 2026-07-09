package com.sfl.product.controller;

import com.sfl.product.service.ProductService;
import com.sfl.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController{
    @Autowired
    private ProductService service;

    @GetMapping("/api/v1/product")
    public List<Product> getAllProduct(){
        return service.getAllProduct();
    }
    @GetMapping("/api/v1/product/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    @GetMapping("/api/v1/product/name/{productName}")
    public Product getProductByName(@PathVariable String productName){
        return service.getProductByName(productName);
    }
    @PostMapping("/api/v1/product")
    public Product postProduct(@RequestBody Product app){
        return service.post(app);
    }
    @PutMapping("/api/v1/product/{id}")
    public Product putProduct(@PathVariable int id, @RequestBody Product app){
        return service.PutProduct(id,app);
    }
    @DeleteMapping("/api/v1/appointments/{id}")
    public String deleteAppointment(@PathVariable int id){return service.deleteProductById(id);}
}

