package com.dag.jwtspringbootjava.repository;

import com.dag.jwtspringbootjava.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserRepository extends JpaRepository<User, Long> {
        User findByUsername(String username);
        }

