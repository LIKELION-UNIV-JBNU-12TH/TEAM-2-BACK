package com.mysite.lion.repository;

import com.mysite.lion.entity.Member;
import com.mysite.lion.entity.OrderList;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderListRepository extends JpaRepository<OrderList, Long> {
    List<OrderList> findByBuyer_Id(String id);
    //List<OrderList> findBySeller_Id(String id);
    List<OrderList> findByProduct_SellerId(String id);
    List<OrderList> findByProduct_Id(Long id);

}
