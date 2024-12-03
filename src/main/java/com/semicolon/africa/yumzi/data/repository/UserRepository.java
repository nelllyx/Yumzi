package com.semicolon.africa.yumzi.data.repository;

import com.semicolon.africa.yumzi.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
