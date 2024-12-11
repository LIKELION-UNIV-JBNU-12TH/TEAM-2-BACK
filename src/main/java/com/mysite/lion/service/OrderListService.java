package com.mysite.lion.service;

import com.mysite.lion.dto.OrderDTO;
import com.mysite.lion.entity.OrderList;
import com.mysite.lion.repository.MemberRepository;
import com.mysite.lion.repository.OrderListRepository;
import com.mysite.lion.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderListService {
    private final OrderListRepository orderListRepository;
    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;

    public List<OrderList> findAll(){
        return orderListRepository.findAll();
    }

    public List<OrderList> findByBuyerId(String id){
        return orderListRepository.findByBuyer_Id(id);
    }

    public List<OrderList> findBySellerId(String id){
        return orderListRepository.findByProduct_SellerId(id);
    }

    public List<OrderList> findByProductId(Long id){
        return orderListRepository.findByProduct_Id(id);
    }

    public ResponseEntity<String> save(OrderDTO formDTO){
        OrderList newOrder = OrderList.builder()
                .product(productRepository.findById(formDTO.getProductId()).get())
                .buyer(memberRepository.findById(formDTO.getBuyerId()).get())
                .build();
        orderListRepository.save(newOrder);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
