package com.semicolon.africa.yumzi.data.repository;

import com.semicolon.africa.yumzi.data.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findCartItemById(Long cartId);
}
