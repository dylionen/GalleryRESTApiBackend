package com.example.back.repositories;

import com.example.back.models.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByRoleName(String roleName);
}
