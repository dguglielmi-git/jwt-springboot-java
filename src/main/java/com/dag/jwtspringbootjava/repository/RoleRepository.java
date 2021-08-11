package com.dag.jwtspringbootjava.repository;

import com.dag.jwtspringbootjava.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public class RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String role);
}