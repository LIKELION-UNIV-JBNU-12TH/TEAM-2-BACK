package com.mysite.lion.service.interfaces;

import com.mysite.lion.dto.ProductDTO;
import com.mysite.lion.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public List<Product> findByName(String name);
    public ResponseEntity<String> save(ProductDTO formDTO);
}
