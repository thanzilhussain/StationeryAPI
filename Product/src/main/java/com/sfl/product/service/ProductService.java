package com.sfl.product.service;

import com.sfl.product.entity.Product;
import com.sfl.product.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repository;

    public Product post(Product app){
        return repository.save(app);
    }
    public List<Product> getAllProduct(){
        return repository.findAll();
    }
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }
    public Product getProductByName(String name){return repository.findByProductName(name);}
    public Product PutProduct(int id, Product app){
        Product existingproduct=repository.findById(id).orElse(null);
        if(existingproduct==null){
            return null;
        }
        existingproduct.setProductName(app.getProductName());
        existingproduct.setProductPrice(app.getProductPrice());
        return repository.save(existingproduct);
    }

    public String deleteProductById(int id){
        Product existingproduct=repository.findById(id).orElse(null);
        if(existingproduct==null){
            return "Product not found";
        }
        repository.delete(existingproduct);
        return "Product deleted";
    }
}
