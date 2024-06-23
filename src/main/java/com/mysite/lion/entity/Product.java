package com.mysite.lion.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable=false)
    private Long id;

    @Column(name = "product_name", nullable=false)
    private String name;

    private Long price;
    private Long stock;

    @Column(name = "seller_id", nullable=false)
    private String sellerId;


}
