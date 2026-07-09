package com.sfl.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String custName;
    private int productId;
    private String productName;
    private double productPrice;
    private int quantity;
    private double totalPrice;
}
