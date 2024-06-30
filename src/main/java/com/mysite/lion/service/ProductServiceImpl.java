package com.mysite.lion.service;

import com.mysite.lion.dto.ProductDTO;
import com.mysite.lion.entity.Product;
import com.mysite.lion.repository.ProductRepository;
import com.mysite.lion.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByName(String name){
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findByKeyword(String keyword) {
        return productRepository.findByNameContaining(keyword);
    }

    @Override
    public ResponseEntity<String> save(ProductDTO formDTO){
        Product newProduct = Product.builder()
                .name(formDTO.getName())
                .price(formDTO.getPrice())
                .description(formDTO.getDescription())
                .stock(formDTO.getStock())
                .sellerId(formDTO.getSellerId())
                .thumbnailId(formDTO.getProductThumbnailId())
                .build();
        productRepository.save(newProduct);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
