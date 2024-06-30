package com.mysite.lion.repository;

import com.mysite.lion.entity.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderListRepository extends JpaRepository<OrderList, Long> {
}
