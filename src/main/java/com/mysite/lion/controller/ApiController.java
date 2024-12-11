package com.mysite.lion.controller;


import com.mysite.lion.dto.LogInDTO;
import com.mysite.lion.dto.OrderDTO;
import com.mysite.lion.dto.ProductDTO;
import com.mysite.lion.dto.SignUpDTO;
import com.mysite.lion.entity.OrderList;
import com.mysite.lion.entity.Product;
import com.mysite.lion.repository.ProductRepository;
import com.mysite.lion.service.OrderListService;
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
    private final ProductServiceImpl productService;
    private final OrderListService orderListService;

    // Member
    @PostMapping("/signup")
    public ResponseEntity<String> userSignup(SignUpDTO formDTO) {
        return memberService.signup(formDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody LogInDTO loginDTO) {
        return memberService.login(loginDTO);
    }

    // Product
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.findAll();
    }

    @GetMapping("/products/find")
    public List<Product> productFindByName(@RequestParam("keyword") String keyword){
        return productService.findByKeyword(keyword);
    }
    @PostMapping("/product/new")
    public ResponseEntity<String> saveProduct(ProductDTO formDTO){
        return productService.save(formDTO);
    }

    // OrderList
    @GetMapping("/orderList")
    public List<OrderList> getOrderList(){
        return orderListService.findAll();
    }

    @GetMapping("/orderList/findByBuyerId")
    public List<OrderList> findByBuyerId(@RequestParam("id") String id){
        return orderListService.findByBuyerId(id);
    }

    @GetMapping("/orderList/findBySellerId")
    public List<OrderList> findBySellerId(@RequestParam("id") String id){
        return orderListService.findBySellerId(id);
    }

    @GetMapping("/orderList/findByProductId")
    public List<OrderList> findByProductId(@RequestParam("id") Long id){
        return orderListService.findByProductId(id);
    }

    @PostMapping("/orderList/new")
    public ResponseEntity<String> saveOrder(OrderDTO formDTO){
        return orderListService.save(formDTO);
    }
}
