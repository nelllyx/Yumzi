package com.semicolon.africa.yumzi.data.repository;

import com.semicolon.africa.yumzi.data.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findCartByUserId(Long userId);
}
