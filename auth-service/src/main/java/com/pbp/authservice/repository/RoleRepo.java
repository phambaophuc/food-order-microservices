package com.pbp.authservice.repository;

import com.pbp.authservice.enums.ERole;
import com.pbp.authservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(ERole role);
}
