package com.semicolon.africa.yumzi.data.repository;

import com.semicolon.africa.yumzi.data.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findOrderById(Long orderId);
}
