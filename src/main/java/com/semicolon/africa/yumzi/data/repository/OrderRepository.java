package com.semicolon.africa.yumzi.data.repository;

import com.semicolon.africa.yumzi.data.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
    Optional<CustomerOrder> findOrderById(Long orderId);
}
