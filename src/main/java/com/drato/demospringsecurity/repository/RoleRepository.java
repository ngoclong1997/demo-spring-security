package com.drato.demospringsecurity.repository;

import com.drato.demospringsecurity.model.Role;
import com.drato.demospringsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
