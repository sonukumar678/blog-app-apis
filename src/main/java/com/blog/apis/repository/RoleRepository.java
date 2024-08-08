package com.blog.apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.apis.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
