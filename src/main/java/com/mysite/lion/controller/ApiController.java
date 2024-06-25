package com.mysite.lion.controller;


import com.mysite.lion.dto.LogInDTO;
import com.mysite.lion.dto.ProductDTO;
import com.mysite.lion.dto.SignUpDTO;
import com.mysite.lion.entity.Product;
import com.mysite.lion.repository.ProductRepository;
import com.mysite.lion.service.ProductServiceImpl;
import com.mysite.lion.service.interfaces.MemberService;
import com.mysite.lion.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final MemberService memberService;
    private ProductRepository productRepository;
    private final ProductServiceImpl productService;

    @PostMapping("/signup")
    public ResponseEntity<String> userSignup(@RequestBody SignUpDTO formDTO) {
        return memberService.signup(formDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody LogInDTO loginDTO) {
        return memberService.login(loginDTO);
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.findAll();
    }

//    @GetMapping("/products")
//    public List<Product> productFindByName(@RequestParam String name){
//        return productService.findByName(name);
//    }
    @PostMapping("/product/new")
    public ResponseEntity<String> saveProduct(ProductDTO formDTO){
        return productService.save(formDTO);
    }
}
