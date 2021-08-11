package com.dag.jwtspringbootjava.service;

import com.dag.jwtspringbootjava.domain.Role;
import com.dag.jwtspringbootjava.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
