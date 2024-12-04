package com.semicolon.africa.yumzi.data.repository;

import com.semicolon.africa.yumzi.data.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Optional<Food> findFoodById(Long id);
    Optional<Food> findFoodByFoodName(String name);
}
