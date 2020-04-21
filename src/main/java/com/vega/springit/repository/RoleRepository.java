package com.vega.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vega.springit.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
